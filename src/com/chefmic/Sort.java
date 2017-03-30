package com.chefmic;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cyuan on 3/29/17.
 */
public class Sort {

    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //待插入元素
            int temp = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
        }
    }

    private void binaryInsertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                nums[j + 1] = nums[j];
            }
            if (left != i) {
                nums[left] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[] array = new int[]{9, 7, 8, 6, 4, 5, 2, 1, 10, 3};
        binaryInsertSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

}
