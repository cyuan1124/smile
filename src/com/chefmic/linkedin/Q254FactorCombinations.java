package com.chefmic.linkedin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q254FactorCombinations {

    List<List<Integer>> result;

    public List<List<Integer>> getFactors(int n) {
        result = new ArrayList<>();
        getFactors(n, 2, new ArrayList<>());
        return result;
    }

    private void getFactors(int n, int r, List<Integer> list) {
        if (r == 1 || r >= n) return;
        for (int i = r; i <= n / 2; i++) {
            if (n % i == 0 && n / i >= i) {
                list.add(i);
                list.add(n / i);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                getFactors(n / i, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        getFactors(8).stream().forEach(list -> {
            list.forEach(num -> System.out.print(num + " "));
            System.out.println();
        } );
    }

}
