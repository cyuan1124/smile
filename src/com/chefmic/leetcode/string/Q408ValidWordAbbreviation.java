package com.chefmic.leetcode.string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 4/9/17.
 */
public class Q408ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int counter = 0, i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char w = word.charAt(i);
            char a = abbr.charAt(j);
            if (Character.isDigit(a)) {
                counter *= 10;
                counter += (a - '0');
                j++;
            } else if (counter > 0) {
                i += counter;
                counter = 0;
            } else if (w != a) {
                return false;
            } else {
                j++;
                i++;
            }
        }

        return j == abbr.length() && word.length() - i == counter;
    }

    @Test
    public void test() {
        assertTrue(validWordAbbreviation("internationalization", "i12iz4n"));
    }

}
