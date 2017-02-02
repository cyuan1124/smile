package com.chefmic.leetcode.backtracking;

import java.util.Arrays;

/**
 * Created by cyuan on 2/1/17.
 */
public class Q377CombinationSumIV {

    public static void main(String[] args) {
        Q377CombinationSumIV tester = new Q377CombinationSumIV();
        System.out.print(tester.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    int count = 0;

    public int combinationSum4(int[] nums, int target) {
        count = 0;
        solve(nums, 0, target);
        return count;
    }

    private void solve(int[] nums, int start, int target) {
        if (target < 0) {
            return;
        } else if (start < nums.length && target == 0) {
            count++;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i != start) {
                    solve(nums, i + 1, target - nums[i]);
                }
            }
        }
    }

}
