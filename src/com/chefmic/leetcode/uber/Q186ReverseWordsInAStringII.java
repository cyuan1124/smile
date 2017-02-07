package com.chefmic.leetcode.uber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cyuan on 2/3/17.
 */
public class Q186ReverseWordsInAStringII {

    public static void main(String[] args) {
        Q186ReverseWordsInAStringII tester = new Q186ReverseWordsInAStringII();
        char[] s = "a b c d e".toCharArray();
        tester.reverseWords(s);
        System.out.println(new String(s));
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0, end = 1;
        while (end <= s.length) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
                end = start + 1;
            } else {
                end++;
            }
        }
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }

}
