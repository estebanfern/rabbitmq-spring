package org.estebanfern.rabbitmqcommons.worker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

public class QueueListener {

    private Queue queue;
    private TopicExchange topicExchange;
    private Binding binding;

    public QueueListener(String queue, String topicExchange, String binding) {
        this.queue = new Queue(queue, false);
        this.topicExchange = new TopicExchange(topicExchange);
        this.binding = new Binding(this.queue.getName(), Binding.DestinationType.QUEUE, this.topicExchange.getName(), binding,null);
    }

    @Bean
    Queue queue() {
        return queue;
    }

    @Bean
    TopicExchange exchange() {
        return topicExchange;
    }

    @Bean
    Binding binding() {
        return binding;
    }

}
