package com.chefmic.linkedin.other;

import java.util.Random;

/**
 * Created by cyuan on 4/2/17.
 */
public class KthLargestNumberInArray {

    /**
     * [ 3,2,1,5,6,4 ]
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }

        Random random = new Random();
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int pivot = low + random.nextInt(high - low + 1);
            int newPivot = partition(low, high, pivot, nums);
            if (newPivot == k - 1) {
                return nums[newPivot];
            } else if (newPivot > k) {
                low = newPivot + 1;
            } else {
                high = newPivot - 1;
            }
        }

        return -1;
    }

    private int partition(int low, int high, int pivot, int[] nums) {
        int pivotValue = nums[pivot];
        int newPivot = low;
        swap(nums, pivot, high);
        for (int i = low; i < high; i++) {
            if (nums[i] >= pivotValue) {
                swap(nums, i, newPivot++);
            }
        }
        swap(nums, high, newPivot);
        return newPivot;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
