package com.chefmic.linkedin.frequency_5;

//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
public class ImptStrStr {

    public static void main(String[] args) {
        System.out.print(((new ImptStrStr()).strStr("abcdefg", "abcdefg")));
    }

    public String strStr(String haystack, String needle) {
        char[] result = new char[haystack.length()];
        char[] n = needle.toCharArray();
        int h_len = haystack.length();
        int n_len = needle.length();
        for (int i = 0; i < h_len - n_len + 1; i++) {
            int j;
            for (j = 0; j < n_len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n_len) {
                return haystack.substring(i);
            }
        }
        return null;

    }

}
