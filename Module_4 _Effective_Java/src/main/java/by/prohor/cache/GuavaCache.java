package by.prohor.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artsiom Prokharau 22.06.2021
 */

public class GuavaCache {

    public Cache<Integer, String> cache = CacheBuilder.newBuilder()
            .initialCapacity(100_000)
            .removalListener((RemovalListener<Integer, String>) notification -> {
                System.out.println("Removed entry: " + notification.getKey() + " -> " + notification.getValue());
                System.out.println("Cause: " + notification.getCause().name());
            })
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();
}


