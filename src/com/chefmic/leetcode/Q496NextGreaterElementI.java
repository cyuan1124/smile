package com.chefmic.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q496NextGreaterElementI {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < result.length; i++) {
            Integer higher = set.higher(findNums[i]);
            result[i] = higher == null ? -1 : higher;
        }
        return result;
    }

    @Test
    public void test() {
        int[] toFind = {4, 1, 2};
        int[] origin = {1, 3, 4, 2};
        Arrays.stream(nextGreaterElement(toFind, origin)).forEach(System.out::println);
    }

}
