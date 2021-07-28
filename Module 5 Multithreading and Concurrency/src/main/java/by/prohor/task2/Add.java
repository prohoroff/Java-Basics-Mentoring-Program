package by.prohor.task2;

import java.util.List;
import java.util.Random;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class Add extends Thread {

    List<Integer> list;
    Random random = new Random();

    public Add(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized(list) {
            while (true) {
                if (random.nextBoolean()){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = random.nextInt(10);
                list.add(i);
                System.out.println("Add value => " + i);
                list.notify();
            }
        }
    }
}
