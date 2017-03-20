package com.chefmic.linkedin;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cyuan on 3/18/17.
 */
public class Q34SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1, end = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        start = left;
        if (nums[left] != target) {
            // Not found
            return new int[] {-1, -1};
        }

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return new int[] {start, right};
    }

    @Test
    public void test() {
        int[] array = new int[] {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(array, 8);
        System.out.println(result[0] + " " + result[1]);
    }

}
