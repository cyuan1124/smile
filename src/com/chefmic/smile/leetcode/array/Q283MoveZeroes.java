package com.chefmic.smile.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * For example, given
 * nums = [0, 1, 0, 3, 12],
 * after calling your function, nums should be
 * [1, 3, 12, 0, 0].
 */
public class Q283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int modify = -1, runner = 0;
        while (runner < nums.length) {
            if (nums[runner] == 0) runner++;
            else {
                nums[++modify] = nums[runner++];
            }
        }

        for (int i = ++modify; i < nums.length; i++)
            nums[i] = 0;
    }

    @Test
    public void test() {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

}
