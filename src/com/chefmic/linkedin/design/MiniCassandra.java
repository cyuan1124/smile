package com.chefmic.linkedin.design;

import java.util.*;

public class MiniCassandra {

    private Map<String, NavigableMap<Integer, Column>> cache;

    public MiniCassandra() {
        // initialize your data structure here.
        cache = new HashMap<>();
    }

    /**
     * @param raw_key a string
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        NavigableMap<Integer, Column> map = cache.getOrDefault(raw_key, new TreeMap<>());
        map.put(column_key, new Column(column_key, column_value));
        cache.put(raw_key, map);
    }

    /**
     * @param raw_key      a string
     * @param column_start an integer
     * @param column_end   an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        NavigableMap<Integer, Column> navigableMap = cache.get(raw_key);
        if (navigableMap == null) {
            return null;
        }
        return new ArrayList<>(navigableMap.subMap(column_start, true, column_end, true).values());
    }
}
