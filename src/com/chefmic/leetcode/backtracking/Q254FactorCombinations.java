package com.chefmic.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/2/17.
 */
public class Q254FactorCombinations {

    public static void main(String[] args) {
        Q254FactorCombinations tester = new Q254FactorCombinations();
        tester.getFactors(12).forEach(list -> {
            list.forEach(num -> System.out.print(num + " "));
            System.out.println();
        });

    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        resolve(n, 2, new ArrayList<>(), result);
        return result;
    }

    private void resolve(int n, int r, List<Integer> list, List<List<Integer>> res) {
        if (r == 1 || r >= n) return;
        for (int i = r; i <= n / 2; i++) {
            if (n % i == 0 && n / i >= i) {
                list.add(i);
                list.add(n / i);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                resolve(n / i, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

}
