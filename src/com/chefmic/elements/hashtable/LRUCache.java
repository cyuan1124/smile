package com.chefmic.elements.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cyuan on 1/15/17.
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> isbnToPrice;

    LRUCache(final int capacity) {
        this.isbnToPrice = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };
    }

    public Integer lookup(Integer key) {
        return isbnToPrice.getOrDefault(key, null);
    }

    public Integer insert(Integer key, Integer value) {
        Integer currentVal = isbnToPrice.get(key);
        if (!isbnToPrice.containsKey(key)) {
            isbnToPrice.put(key, value);
            return currentVal;
        } else {
            return null;
        }
    }

    public Integer erase(Object key) {
        return isbnToPrice.remove(key);
    }

}
