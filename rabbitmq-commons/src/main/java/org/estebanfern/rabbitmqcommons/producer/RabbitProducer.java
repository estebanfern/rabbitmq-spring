package org.estebanfern.rabbitmqcommons.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.estebanfern.rabbitmqcommons.service.RabbitMqService;
import org.estebanfern.rabbitmqcommons.service.impl.RabbitMqServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitProducer {

    protected final RabbitMqService rabbitMqService;

    public RabbitProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitMqService = new RabbitMqServiceImpl(rabbitTemplate, objectMapper);
    }

}
