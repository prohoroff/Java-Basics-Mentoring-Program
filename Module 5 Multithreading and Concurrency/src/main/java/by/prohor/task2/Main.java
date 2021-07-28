package by.prohor.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        new Add(list).start();
        new Sum(list).start();
        new Print(list).start();

    }
}
