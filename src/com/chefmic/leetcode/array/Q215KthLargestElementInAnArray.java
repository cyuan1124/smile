package com.chefmic.leetcode.array;

import java.util.Random;

/**
 * Created by cyuan on 1/31/17.
 */
public class Q215KthLargestElementInAnArray {

    public static void main(String[] args) {
        Q215KthLargestElementInAnArray tester = new Q215KthLargestElementInAnArray();
        System.out.println(tester.findKthLargest(new int[]{2, 1}, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random r = new Random(0);
        while (left <= right) {
            int pivotIdx = r.nextInt(right - left + 1) + left;
            int newPivot = partition(left, right, pivotIdx, nums);
            if (newPivot == k - 1) {
                return nums[newPivot];
            } else if (newPivot > k - 1) {
                right = newPivot - 1;
            } else {
                left = newPivot + 1;
            }
        }
        return -1;
    }

    int partition(int left, int right, int pivotIdx, int[] nums) {
        int pivotValue = nums[pivotIdx];
        int newPivotIndex = left;
        swap(nums, pivotIdx, right);
        for (int i = left; i < right; i++) {
            if (nums[i] >= pivotValue) {
                swap(nums, i, newPivotIndex++);
            }
        }
        swap(nums, right, newPivotIndex);
        return newPivotIndex;
    }

    void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
