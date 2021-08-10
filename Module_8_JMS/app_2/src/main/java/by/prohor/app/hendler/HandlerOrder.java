package by.prohor.app.hendler;

import by.prohor.app.entity.Order;
import by.prohor.app.service.ServiceOrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

@Component
public class HandlerOrder {

    private static final String ORDER_QUEUE = "order.queue";
    private static final String REJECTED_QUEUE = "order.queue.rejected";
    private static final String ACCEPTED_QUEUE = "order.queue.accepted";

    private static final int MAX_COUNT = 10;
    private static final int MAX_VOLUME = 1000;

    @Autowired
    private ServiceOrderSender serviceOrderSender;

    @JmsListener(destination = ORDER_QUEUE)
    public void receive(Order order) {
        System.out.println("Order Received = " + order);
        switch (order.getType()) {
            case "countable":
                if (Integer.parseInt(order.getCount()) < MAX_COUNT) {
                    sendOrderAccepted(order);
                    break;
                } else {
                    sendOrderRejected(order);
                    break;
                }
            case "liquids":
                if (Integer.parseInt(order.getVolume()) < MAX_VOLUME) {
                    sendOrderAccepted(order);
                    break;
                } else {
                    sendOrderRejected(order);
                    break;
                }
        }
    }

    private void sendOrderAccepted(Order order) {
        System.out.println("The order accepted");
        serviceOrderSender.send(ACCEPTED_QUEUE, order);
    }

    private void sendOrderRejected(Order order) {
        System.out.println("The order should be rejected");
        serviceOrderSender.send(REJECTED_QUEUE, order);
    }
}
