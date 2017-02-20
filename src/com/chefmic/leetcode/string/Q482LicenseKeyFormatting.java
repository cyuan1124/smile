package com.chefmic.leetcode.string;

import org.junit.Test;

/**
 * Created by cyuan on 2/17/17.
 */
public class Q482LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        char[] str = new char[S.length() + S.length() / K + 1];
        int index = str.length - 1, runner = S.length() - 1;

        int count = 0;
        while (runner >= 0) {
            if (Character.isLetterOrDigit(S.charAt(runner))) {
                str[index--] = S.charAt(runner--);
                count++;
                if (count == K) {
                    str[index--] = '-';
                    count = 0;
                }
            } else {
                runner--;
            }
        }

        while (index >= 0) {
            str[index--] = ' ';
        }
        String result = new String(str).trim().toUpperCase();
        if (result.length() > 0 && result.charAt(0) == '-') return result.substring(1);
        return result;
    }

    @Test
    public void test() {
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 3));
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 1));
    }

}
