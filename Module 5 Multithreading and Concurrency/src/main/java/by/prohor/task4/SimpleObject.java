package by.prohor.task4;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class SimpleObject extends Thread {

    Boolean status;
    SimpleObjectPool simpleObjectPool;

    public SimpleObject() {
    }

    public SimpleObject(Boolean status, SimpleObjectPool simpleObjectPool) {
        this.status = status;
        this.simpleObjectPool = simpleObjectPool;
    }

    @Override
    public void run() {
        while(true) {
            if (status) {
                Object obj = simpleObjectPool.get();
            } else {
                simpleObjectPool.take(new SimpleObject());
            }
        }
    }
}
