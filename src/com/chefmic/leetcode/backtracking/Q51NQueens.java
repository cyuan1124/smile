package com.chefmic.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/1/17.
 */
public class Q51NQueens {

    public static void main(String[] args) {
        Q51NQueens tester = new Q51NQueens();
        tester.solveNQueens(4).stream().forEach(list -> list.stream().forEach(System.out::println));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        // solve queens
        solveQueen(n, 0, new ArrayList<>(), res);
        // convert to string
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> list : res) {
            result.add(convert(n, list));
        }
        return result;
    }

    private List<String> convert(int n, List<Integer> list) {
        List<String> res = new ArrayList<>(n);
        for (Integer row : list) {
            char[] str = new char[n];
            for (int i = 0; i < n; i++) {
                str[i] = (row == i) ? 'Q' : '.';
            }
            res.add(new String(str));
        }
        return res;
    }

    private void solveQueen(int n, int row, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
        } else {
            for (int col = 0; col < n; col++) {
                list.add(col);
                if (isValid(list)) {
                    solveQueen(n, row + 1, list, res);
                }
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> list) {
        int rowId = list.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(list.get(i) - list.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }

}
