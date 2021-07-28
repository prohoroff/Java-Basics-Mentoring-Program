package by.prohor.task6;

import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * Created by Artsiom Prokharau 29.06.2021
 */

public class Main {

    public static void main(String[] args) {
        Generator generator = new Generator();
        Producer pr = new Producer(generator);
        Consumer cons = new Consumer(generator);
        pr.start();
        cons.start();
    }
}


class Generator {
    List<Integer> random;
    boolean isProduced;

    synchronized void getAverageValue() {
        if (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get average value => " + this.random.stream().mapToInt(Integer::intValue).average());
        isProduced = false;
        notify();
    }

    synchronized void randomValues(Generator generator) {
        if (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Create random value => " + this.random);
        isProduced = true;
        notify();
    }
}

class Producer extends Thread {
    Generator generator;
    int count;

    Producer(Generator generator) {
        this.generator = generator;
    }

        @Override
        public void run() {
            while (true) {
                generator.getAverageValue();
                count++;
            }
        }
}

class Consumer extends Thread {
    Generator generator;
    int count;

    Consumer(Generator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        while (true) {
            generator.getAverageValue();
            count++;
        }
    }
}
