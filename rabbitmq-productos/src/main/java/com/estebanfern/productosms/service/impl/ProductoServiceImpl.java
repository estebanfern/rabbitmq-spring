package com.estebanfern.productosms.service.impl;

import com.estebanfern.productosms.dao.ProductoDao;
import com.estebanfern.productosms.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.estebanfern.rabbitmqcommons.bean.Producto;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.ProductoReq;
import org.estebanfern.rabbitmqcommons.dto.req.CompraReq;
import org.estebanfern.rabbitmqcommons.producer.RabbitProducer;
import org.estebanfern.rabbitmqcommons.utils.ProductoUtils;
import org.estebanfern.rabbitmqcommons.utils.TransaccionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends RabbitProducer implements ProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);

    private final ProductoDao productoDao;

    public ProductoServiceImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper, ProductoDao productoDao) {
        super(rabbitTemplate, objectMapper);
        this.productoDao = productoDao;
    }

    @Override
    public Producto save(ProductoReq productoReq) {
        Producto producto = ProductoUtils.productoFromRequest(productoReq);
        productoDao.save(producto);
        return producto;
    }

    @Override
    public Transaccion addStock(CompraReq compraReq) throws JsonProcessingException {
        logger.info("CompraReq: {}", compraReq);
        Transaccion transaccion = TransaccionUtils.transaccionFromCompra(compraReq);
        rabbitMqService.enqueue("producto.stock.exchange", "producto.stock.route", transaccion);
        return transaccion;
    }

    @Override
    public void sendTransaccion(Transaccion transaccion) throws JsonProcessingException {
        logger.info("Transaccion: {}", transaccion);
        rabbitMqService.enqueue("tramsaction.persistance.exchange", "tramsaction.persistance.route", transaccion);
    }

}
