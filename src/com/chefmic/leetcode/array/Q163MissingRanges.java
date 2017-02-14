package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/13/17.
 */
public class Q163MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        addDiff(result, lower - 1, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            addDiff(result, nums[i - 1], nums[i]);
        }
        addDiff(result, nums[nums.length - 1], upper + 1);
        return result;
    }

    private void addDiff(List<String> result, int start, int end) {
        if (end - start == 1) return;
        if (end - start == 2) {
            result.add(String.valueOf(end - 1));
        } else {
            result.add(String.format("%d->%d", start + 1, end - 1));
        }
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 3, 50, 75};
        findMissingRanges(nums, 0, 99).stream().forEach(System.out::println);
    }

}
