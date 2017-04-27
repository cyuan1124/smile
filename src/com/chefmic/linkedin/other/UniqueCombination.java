package com.chefmic.linkedin.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 4/16/17.
 */
public class UniqueCombination {

    private List<List<Integer>> combine(int n) {
        List<List<Integer>> res = new ArrayList<>();
        solve(n, new ArrayList<>(), res);
        return res;
    }

    private void solve(int n, List<Integer> list, List<List<Integer>> res) {
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                if (n - i >= i) {
                    list.add(i);
                    list.add(n - i);
                    res.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                    solve(n - i, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    @Test
    public void test() {
        combine(4).forEach(list -> {
            list.forEach(i -> System.out.print(" " + i));
            System.out.println();
        });
    }

}
