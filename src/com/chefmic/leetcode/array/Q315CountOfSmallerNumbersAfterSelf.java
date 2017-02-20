package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by cyuan on 2/19/17.
 */
public class Q315CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(nums[i], 1 + map.headMap(nums[i], false).values().stream().max(Integer::compareTo).orElse(0));
            result.add(map.get(nums[i]) - 1);
        }
        Collections.reverse(result);
        return result;
    }

    @Test
    public void test() {
        countSmaller(new int[]{5, 2, 6, 1}).stream().forEach(System.out::println);
        countSmaller(new int[]{2, 0, 1}).stream().forEach(System.out::println);
    }

}
