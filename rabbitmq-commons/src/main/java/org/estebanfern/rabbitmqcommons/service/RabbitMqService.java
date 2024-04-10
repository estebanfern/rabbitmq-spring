package org.estebanfern.rabbitmqcommons.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RabbitMqService {
    void enqueue(String exchange, String route, Object message) throws JsonProcessingException;
}
