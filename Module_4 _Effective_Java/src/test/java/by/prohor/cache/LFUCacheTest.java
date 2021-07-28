package by.prohor.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    LFUCache lfuCache = new LFUCache();



    @Test
    void testCache(){
        for (int i = 0; i < 100_200; i++) {
            lfuCache.put(i, String.valueOf(i));
        }

        assertEquals("199 was deleted",lfuCache.get(0));
    }
}