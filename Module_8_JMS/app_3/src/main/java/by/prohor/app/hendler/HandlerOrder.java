package by.prohor.app.hendler;

import by.prohor.app.entity.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

@Component
public class HandlerOrder {

    private static final String REJECTED_QUEUE = "order.queue.rejected";
    private static final String ACCEPTED_QUEUE = "order.queue.accepted";

    @JmsListener(destination = ACCEPTED_QUEUE)
    public void receiveAccepted(Order order) {
        writeOrderToFile("accepted.txt", order);
    }

    @JmsListener(destination = REJECTED_QUEUE)
    public void receiveRejected(Order order) {
        writeOrderToFile("rejected.txt", order);
    }

    private void writeOrderToFile(String fileName, Order order) {
        File file = new File("/home/prohor/IdeaProjects/Java Basics Mentoring/Module_8_JMS/app_3/src/main/resources/" + fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()))) {
            writer.write(format("%s%n", order));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
