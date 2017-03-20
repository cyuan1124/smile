package com.chefmic.linkedin;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cyuan on 3/18/17.
 */
public class Q238ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(Arrays.binarySearch(new int[]{2, 3, 4, 5}, 1));
        System.out.println(Arrays.binarySearch(new int[]{2, 3, 4, 5}, 6));
    }

}
