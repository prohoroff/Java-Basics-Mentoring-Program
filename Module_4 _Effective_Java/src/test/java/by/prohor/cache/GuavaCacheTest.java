package by.prohor.cache;

import com.google.common.cache.Cache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuavaCacheTest {

    Cache<Integer, String> guavaCache = new GuavaCache().cache;


    @BeforeEach
    void clear() {
        guavaCache.cleanUp();
    }

    @Test
    void testCacheLastAccessFiveSeconds() throws InterruptedException {
        guavaCache.put(1, "One");
        guavaCache.put(2, "Two");
        guavaCache.put(3, "Three");
        guavaCache.put(4, "Four");
        guavaCache.put(5, "Five");
        guavaCache.put(6, "Five");
        guavaCache.put(7, "Five");
        Thread.sleep(6000);
        Assertions.assertNull(guavaCache.asMap().get(5));

    }
}