package com.chefmic.leetcode.string;

import org.junit.Test;

/**
 * Created by cyuan on 4/8/17.
 */
public class Q541ReverseStringII {

    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] str = s.toCharArray();
        if (str.length <= k) {
            reverse(str, 0, str.length - 1);
        } else {
            for (int i = k; i < s.length(); i += k) {
                reverse(str, i - k, i - 1);
            }
        }

        return new String(str);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char c = str[start];
            str[start++] = str[end];
            str[end--] = c;
        }
    }

    @Test
    public void test() {
        System.out.println(reverseStr("abcdefg", 2));
    }

}
