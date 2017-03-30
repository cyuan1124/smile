package com.chefmic.linkedin;

import org.junit.Test;

/**
 * Created by cyuan on 3/20/17.
 */
public class Q151ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] str = s.trim().toCharArray();
        reverse(str, 0, str.length - 1);
        int i = 0, j = 0;

        while (i < str.length) {
            if (str[i] == ' ') {
                i++;
            } else {
                for (j = i + 1; j != str.length && str[j] != ' '; j++) ;
                reverse(str, i, j - 1);
                i = j + 1;
            }
        }

        return new String(str);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start++] = str[end];
            str[end--] = tmp;
        }
    }

    @Test
    public void test() {
        System.out.println(reverseWords("the sky is blue "));
        System.out.println(reverseWords("a "));
    }

}
