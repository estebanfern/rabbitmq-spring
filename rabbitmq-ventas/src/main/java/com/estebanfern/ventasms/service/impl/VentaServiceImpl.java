package com.estebanfern.ventasms.service.impl;

import com.estebanfern.ventasms.service.VentaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.VentaReq;
import org.estebanfern.rabbitmqcommons.producer.RabbitProducer;
import org.estebanfern.rabbitmqcommons.service.RabbitMqService;
import org.estebanfern.rabbitmqcommons.service.impl.RabbitMqServiceImpl;
import org.estebanfern.rabbitmqcommons.utils.TransaccionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl extends RabbitProducer implements VentaService {

    private static final Logger logger = LoggerFactory.getLogger(VentaServiceImpl.class);

    public VentaServiceImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        super(rabbitTemplate, objectMapper);
    }

    @Override
    public Transaccion save(VentaReq ventaReq) throws JsonProcessingException {
        logger.info("Venta: {}", ventaReq);
        Transaccion transaccion = TransaccionUtils.transaccionFromVenta(ventaReq);
        rabbitMqService.enqueue("producto.stock.exchange", "producto.stock.route", transaccion);
        return transaccion;
    }

}
