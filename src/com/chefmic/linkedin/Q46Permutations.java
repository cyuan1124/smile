package com.chefmic.linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 3/17/17.
 */
public class Q46Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(new ArrayList<Integer>(), res, nums);
        return res;
    }

    private void permute(List<Integer> list, List<List<Integer>> res, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                permute(list, res, nums);
                list.remove(list.size() - 1);
            }
        }
    }


}
