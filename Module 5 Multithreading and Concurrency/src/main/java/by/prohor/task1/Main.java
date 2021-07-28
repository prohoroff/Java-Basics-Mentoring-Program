package by.prohor.task1;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AddAndSum addAndSum = new AddAndSum();
        addAndSum.start();

//        в случае с Collections.synchronizedMap данный должны быть синхронизированны
        synchronized (addAndSum.map) {
            for (int i = 1; i < 20; i++) {
                Thread.sleep(1);
                addAndSum.map.put(i, i * i);
                if (i == 19) {
                    addAndSum.setStatus(false);
                }
                 }
            }
        }
    }
