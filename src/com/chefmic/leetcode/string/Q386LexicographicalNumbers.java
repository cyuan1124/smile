package com.chefmic.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/16/17.
 */
public class Q386LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i < n) {
                result.add(i);
                add(i * 10, n, result);
            }
        }
        return result;
    }

    private void add(int start, int target, List<Integer> result) {
        if (start >= target) return;

        for (int i = 0; i <= 9; i++) {
            int num = start + i;
            if (num < target) {
                result.add(num);
                add(num * 10, target, result);
            } else {
                return;
            }
        }
    }

    @Test
    public void test() {
        lexicalOrder(114).stream().forEach(System.out::println);
    }

}
