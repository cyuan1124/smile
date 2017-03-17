package com.chefmic.smile.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class Q1TwoSum {

    public int[] twoSumIndex(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{nums[start], nums[end]};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        throw new AssertionError("No answer found");
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new AssertionError("No answer found");
    }

    @Test
    public void test() {
        int[] result = twoSumIndex(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{2, 7}, result);

        result = twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

}
