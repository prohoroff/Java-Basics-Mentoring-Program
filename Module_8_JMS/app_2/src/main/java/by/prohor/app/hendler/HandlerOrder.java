package by.prohor.app.hendler;

import by.prohor.app.entity.Order;
import by.prohor.app.entity.Result;
import by.prohor.app.service.ServiceOrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

@Component
public class HandlerOrder {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerOrder.class);

    private static final String COLOR_CONSOLE = (char) 27 + "[31m";

    private static final String ORDER_QUEUE = "order.queue";
    private static final String SORTED_QUEUE = "order.queue.sorted";


    private static final int MAX_COUNT = 10;
    private static final int MAX_VOLUME = 1000;

    @Autowired
    private ServiceOrderSender serviceOrderSender;

    @JmsListener(destination = ORDER_QUEUE)
    public void receive(Order order) {
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
        LOGGER.info("{} Order Received ({}) and accepted",COLOR_CONSOLE, order);
        serviceOrderSender.send(SORTED_QUEUE, order, Result.ACCEPT.getResult());
    }

    private void sendOrderRejected(Order order) {
        LOGGER.info("{} Order Received ({}) and rejected",COLOR_CONSOLE, order);
        serviceOrderSender.send(SORTED_QUEUE, order, Result.REJECT.getResult());
    }
}
