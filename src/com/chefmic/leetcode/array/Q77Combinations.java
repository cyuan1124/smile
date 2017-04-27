package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 4/16/17.
 */
public class Q77Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        solve(n, 1, k, new ArrayList<>(), res);
        return res;
    }

    private void solve(int n, int r, int k, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = r; i <= n; i++) {
                list.add(i);
                solve(n, r + 1, k - 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        combine(4, 2).forEach(list -> list.forEach(i -> System.out.print(" " + i)));
    }

}
