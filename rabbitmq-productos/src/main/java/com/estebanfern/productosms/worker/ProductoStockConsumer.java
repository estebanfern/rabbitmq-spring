package com.estebanfern.productosms.worker;

import com.estebanfern.productosms.dao.ProductoDao;
import com.estebanfern.productosms.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.worker.QueueListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ProductoStockConsumer extends QueueListener {

    private static final Logger logger = LoggerFactory.getLogger(ProductoStockConsumer.class);

    private final ObjectMapper objectMapper;
    private final ProductoDao productoDao;
    private final ProductoService productoService;

    public ProductoStockConsumer(ObjectMapper objectMapper, ProductoDao productoDao, ProductoService productoService) {
        super("producto.stock.queue", "producto.stock.exchange", "producto.stock.route");
        this.objectMapper = objectMapper;
        this.productoDao = productoDao;
        this.productoService = productoService;
    }

    @RabbitListener(queues = "producto.stock.queue")
    public void listener(String object) throws JsonProcessingException {
        Transaccion stockReq = objectMapper.readValue(object, Transaccion.class);
        logger.info("Received: {}", stockReq);
        productoDao.updateStock(stockReq);
        productoService.sendTransaccion(stockReq);
    }

}
