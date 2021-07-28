package by.prohor.task4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class SimpleObjectPool {

    private final Integer size;
    private final List<Object> list = new LinkedList<>();

    /**
     * Creates filled pool of passed size *
     * * @param size of pool
     */
    public SimpleObjectPool(int size) {
        this.size = size;
    }

    /**
     * Gets object from pool or blocks if pool is empty *
     * * @return object from pool
     */

    public synchronized Object get() {
        if (list.isEmpty()) {
            try {
                wait();
                System.out.println("list is empty. Thread block");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return list.get(0);
    }

        /**
         * Puts object to pool or blocks if pool is full *
         * * @param object to be taken back to pool
         */

        public synchronized void take(Object obj){
            if (list.size() == size) {
                try {
                    wait();
                    System.out.println("list is full. Thread block");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);
            notify();
        }

}
