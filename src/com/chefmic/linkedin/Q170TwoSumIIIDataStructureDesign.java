package com.chefmic.linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cyuan on 4/11/17.
 */
public class Q170TwoSumIIIDataStructureDesign {

    class TwoSum {

        Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            map = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Integer key : map.keySet()) {
                if (map.containsKey(value - key)) {
                    if (value - key != key) {
                        return true;
                    }
                    if (map.get(key) > 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
