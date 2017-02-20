package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 2/17/17.
 */
public class Q473MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) return false;

        Arrays.sort(nums);
        reverse(nums);

        return dfs(nums, new int[4], 0, sum / 4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
        assertTrue(makesquare(new int[]{1, 1, 2, 2, 2}));
        assertFalse(makesquare(new int[]{3, 3, 3, 3, 4}));
    }

}
