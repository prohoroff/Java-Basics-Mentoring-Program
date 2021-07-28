package by.prohor.task1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Artsiom Prokharau 26.06.2021
 */

public class AddAndSum extends Thread {

//    Map<Integer, Integer> map = new HashMap<>();
final Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
//    Map<Integer, Integer> map = new ConcurrentHashMap<>();

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void run() {
        while (status) {
            int sum = map.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println(sum);
        }
    }
}
