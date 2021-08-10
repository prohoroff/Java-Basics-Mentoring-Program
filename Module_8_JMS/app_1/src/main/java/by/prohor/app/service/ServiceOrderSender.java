package by.prohor.app.service;

import by.prohor.app.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSConsumer;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

@Service
public class ServiceOrderSender {

    private static final String ORDER_QUEUE = "order.queue";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Order order) {
        jmsTemplate.convertAndSend(ORDER_QUEUE, order);
    }
}
