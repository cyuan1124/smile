package com.chefmic.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cyuan on 2/1/17.
 */
public class Q78Subsets {

    public static void main(String[] args) {
        Q78Subsets tester = new Q78Subsets();
        tester.subsets(new int[] {1,2,3}).stream().forEach(list -> {
            list.stream().forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
