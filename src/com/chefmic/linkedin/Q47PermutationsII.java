package com.chefmic.linkedin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cyuan on 3/18/17.
 */
public class Q47PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        permute(new ArrayList<>(), result, nums, new boolean[nums.length]);
        return result;
    }

    private void permute(List<Integer> list, List<List<Integer>> result, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                list.add(nums[i]);
                permute(list, result, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[] {1, 1, 2};
        for (List<Integer> list : permuteUnique(nums)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
