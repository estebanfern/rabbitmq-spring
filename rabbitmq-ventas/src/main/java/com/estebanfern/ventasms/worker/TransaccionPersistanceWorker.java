package com.estebanfern.ventasms.worker;

import com.estebanfern.ventasms.dao.TransaccionDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.worker.QueueListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TransaccionPersistanceWorker extends QueueListener {

    private static final Logger logger = LoggerFactory.getLogger(TransaccionPersistanceWorker.class);

    private final ObjectMapper objectMapper;
    private final TransaccionDao transaccionDao;

    public TransaccionPersistanceWorker(ObjectMapper objectMapper, TransaccionDao transaccionDao) {
        super("tramsaction.persistance.queue", "tramsaction.persistance.exchange", "tramsaction.persistance.route");
        this.objectMapper = objectMapper;
        this.transaccionDao = transaccionDao;
    }

    @RabbitListener(queues = "tramsaction.persistance.queue")
    public void listener(String object) throws JsonProcessingException {
        Transaccion tx = objectMapper.readValue(object, Transaccion.class);
        logger.info("Received: {}", tx);
        transaccionDao.save(tx);
    }

}
