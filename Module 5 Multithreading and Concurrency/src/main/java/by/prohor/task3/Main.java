package by.prohor.task3;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        Producer pr = new Producer(message, 4);
        Consumer cons = new Consumer(message, 4);
        pr.start();
        cons.start();
    }
}

class Message {
    String message;
    boolean isProduced;

    synchronized void getMessage() {
        if (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get message => " + this.message);
        isProduced = false;
        notify();
    }

    synchronized void setMessage(String message) {
        if (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        System.out.println("Set message => " + this.message);
        isProduced = true;
        notify();
    }
}

class Producer extends Thread {
    Message msg;
    int count;

    Producer(Message msg, int count) {
        this.msg = msg;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            msg.setMessage(RandomStringUtils.randomAlphabetic(10));
        }
    }
}

class Consumer extends Thread {
    Message msg;
    int count;

    Consumer(Message msg, int count) {
        this.msg = msg;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            msg.getMessage();
        }
    }
}
