package com.chefmic.leetcode.string;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by cyuan on 1/17/17.
 */
public class Q22GenerateParentheses {

    public static void main(String[] args) {
        Q22GenerateParentheses generator = new Q22GenerateParentheses();
        generator.generateParenthesis(4).stream().forEach(System.out::println);

        // (())(())
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
