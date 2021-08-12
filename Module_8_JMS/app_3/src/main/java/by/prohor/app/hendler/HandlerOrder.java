package by.prohor.app.hendler;

import by.prohor.app.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.lang.String.format;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

@Component
public class HandlerOrder {


    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerOrder.class);

    private static final String COLOR_CONSOLE = (char) 27 + "[31m";

    private static final String SORTED_QUEUE = "order.queue.sorted";

    @JmsListener(destination = SORTED_QUEUE,selector = "result = 'accepted'")
    public void receiveAccepted(Order order) {
        LOGGER.info("{} accept order", COLOR_CONSOLE);
        writeOrderToFile("accepted.txt", order);
    }

    @JmsListener(destination = SORTED_QUEUE,selector = "result = 'rejected'")
    public void receiveRejected(Order order) {
        LOGGER.info("{} rejected order",COLOR_CONSOLE);
        writeOrderToFile("rejected.txt", order);
    }

    private void writeOrderToFile(String fileName, Order order) {
        LOGGER.info("{} write to file {} this order -> {}",COLOR_CONSOLE,fileName, order);
        File file = new File("/home/prohor/IdeaProjects/Java Basics Mentoring/Module_8_JMS/app_3/src/main/resources/" + fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()), StandardOpenOption.APPEND)) {
            writer.write(format("%s%n", order));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
