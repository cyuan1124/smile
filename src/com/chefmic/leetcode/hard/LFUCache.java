package com.chefmic.leetcode.hard;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    final int capacity;
    final LinkedHashMap<Integer, Integer> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    /**
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }

    /**
     * Set or insert the value if the key is not already present.
     */
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        cache.put(key, value);

        if (cache.size() == capacity) {
            Map.Entry<Integer, Integer> entry = cache.entrySet().iterator().next();
            cache.remove(entry.getKey());
        }

    }

}