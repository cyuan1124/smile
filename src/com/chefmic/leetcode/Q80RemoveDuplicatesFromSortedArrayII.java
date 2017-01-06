package com.chefmic.leetcode;

import java.util.Arrays;

/**
 * Created by cyuan on 1/2/17.
 */
public class Q80RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

}
