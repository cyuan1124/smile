package com.chefmic.leetcode.array;

import java.util.Arrays;

/**
 * Created by cyuan on 1/1/17.
 */
public class Q75SortColors {

    public static void main(String... args) {
        Q75SortColors tester = new Q75SortColors();
        int[] nums = new int[]{2, 1};
        tester.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int red = 0, blue = nums.length - 1;
        // Move all red to the front
        for (red = 0; red < nums.length; red++) {
            if (nums[red] == 0) {
                continue;
            }
            // Find next white;
            int j = red + 1;
            for (; j < nums.length; j++) {
                if (nums[j] == 0) {
                    swap(nums, red, j);
                    break;
                }
            }
            if (j == nums.length) {
                break; // No more red found
            }
        }

        for (blue = nums.length - 1; blue >= red; blue--) {
            if (nums[blue] == 2) {
                continue;
            }
            int j = blue - 1;
            for (; j >= red; j--) {
                if (nums[j] == 2) {
                    swap(nums, blue, j);
                    break;
                }
            }

            if (j == red) {
                break; // No more blue found
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
