package com.chefmic.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/4/17.
 */
public class Q320GeneralizedAbbreviation {

    public static void main(String[] args) {
        Q320GeneralizedAbbreviation tester = new Q320GeneralizedAbbreviation();
        tester.generateAbbreviations("word").stream().forEach(System.out::println);
    }

    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            ret.add(cur);
        } else {
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }
}
