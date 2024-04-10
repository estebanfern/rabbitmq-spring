package org.estebanfern.rabbitmqcommons.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.estebanfern.rabbitmqcommons.service.RabbitMqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@AllArgsConstructor
public class RabbitMqServiceImpl implements RabbitMqService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqServiceImpl.class);

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void enqueue(String exchange, String route, Object message) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(exchange, route, objectMapper.writeValueAsString(message));
        logger.info("Message sent. Exchange: {} Route: {} Message: {}", exchange, route, message);
    }

}
