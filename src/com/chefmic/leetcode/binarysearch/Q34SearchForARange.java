package com.chefmic.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Created by cyuan on 1/17/17.
 */
public class Q34SearchForARange {

    public static void main(String[] args) {
        Arrays.stream(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)).forEach(System.out::println);
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int left = mid, right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }

                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                return new int[]{left + 1, right - 1};
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

}
