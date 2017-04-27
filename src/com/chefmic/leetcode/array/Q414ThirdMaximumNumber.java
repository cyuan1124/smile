package com.chefmic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 4/9/17.
 */
public class Q414ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (int num : nums) {
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        return third == null ? first : third;
    }

    @Test
    public void test() {
        assertEquals(2, thirdMax(new int[] {1, 2}));
    }

}
