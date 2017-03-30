package com.chefmic.leetcode.hard;

import org.junit.Test;

import java.util.*;

public class LFUCache {

    class Cache {
        long datetime;
        int key;
        int value;
        int operations;
    }

    private final int capacity;
    private final PriorityQueue<Cache> heap;
    private final Map<Integer, Cache> cache;
    int datetime = 0;
    // @param capacity, an integer
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.heap = new PriorityQueue<>(new Comparator<Cache>() {
            @Override
            public int compare(Cache o1, Cache o2) {
                return o1.operations == o2.operations ?
                        Integer.compare(o1.operations, o2.operations)
                        : Long.compare(o1.datetime, o2.datetime);
            }
        });
        this.cache = new HashMap<>();
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.size() == capacity) {
            Cache leastRecent = heap.poll();
            cache.remove(leastRecent.key);
        }

        Cache c = cache.getOrDefault(key, new Cache());
        heap.remove(c);
        c.key = key;
        c.value = value;
        c.operations++;
        c.datetime = datetime++;
        heap.add(c);
        cache.put(key, c);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Cache c = cache.get(key);
        heap.remove(c);
        c.operations++;
        c.datetime++;
        heap.add(c);
        return c.value;
    }

}