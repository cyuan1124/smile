package com.chefmic.leetcode.hard;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cyuan on 2/8/17.
 */
public class Q460LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);
        System.out.println(cache.get(2));       // returns 1
        System.out.println(cache.get(1));       // returns 1
        System.out.println(cache.get(2));       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.put(4, 4);    // evicts key 2
        System.out.println(cache.get(3));       // returns -1 (not found)
        System.out.println(cache.get(2));       // returns 3.
        System.out.println(cache.get(1));       // returns 3.
        System.out.println(cache.get(4));       // returns 3.
    }



}
