package by.prohor.task2;

import java.util.List;
import java.util.Random;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class Print extends Thread {

    List<Integer> list;
    Random r = new Random();

    public Print(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (list.size() < 100_000) {
                if (r.nextBoolean()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                double sum = list.stream().mapToDouble(Integer::intValue).sum();
                System.out.println("Square root => " + Math.sqrt(sum));
                list.notify();
            }
        }
    }
}
