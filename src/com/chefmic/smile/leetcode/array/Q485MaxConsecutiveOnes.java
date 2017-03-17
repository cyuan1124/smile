package com.chefmic.smile.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class Q485MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) length++;
            else {
                max = Math.max(length, max);
                length = 0;
            }
        }
        return Math.max(length, max);
    }

    @Test
    public void test() {
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

}
