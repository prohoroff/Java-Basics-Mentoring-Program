package by.prohor.task4;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class Main  {
    public static void main(String[] args) {
        SimpleObjectPool simpleObjectPool = new SimpleObjectPool(4);


        SimpleObject s1 = new SimpleObject(true,simpleObjectPool);
        SimpleObject s2 = new SimpleObject(false,simpleObjectPool);


        s1.start();
        s2.start();
    }
}
