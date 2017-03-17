package com.chefmic.smile.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Q118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            if (i != 0) {
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }

    @Test
    public void test() {
        generate(0).stream().forEach(list -> {
            list.stream().map(num -> num + ",").forEach(System.out::print);
            System.out.println();
        });
    }

}
