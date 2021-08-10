package by.prohor.app.service;

import by.prohor.app.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

@Service
public class ServiceOrderSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String rejectedQueue, Order order) {
        jmsTemplate.convertAndSend(rejectedQueue, order);
    }
}
