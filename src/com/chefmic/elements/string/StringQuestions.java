package com.chefmic.elements.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 1/17/17.
 */
public class StringQuestions {

    public static void main(String[] args) {
        phoneMnemonic("1024").stream().forEach(System.out::println);
    }

    /**
     * Q1. Convert int to String and vise versa
     */
    public static int parseInt(String val) {
        boolean negative = val.charAt(0) == '-';
        int num = 0;
        for (int i = negative ? 1 : 0; i < val.length(); i++) {
            num = num * 10 + (val.charAt(i) - '0');
        }
        return negative ? -num : num;
    }

    public static String valueOf(int num) {
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }
        if (negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    /**
     * Q5 Test Palindromicity
     */
    public static boolean testPalindromincity(String str) {
        str = str.toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (!Character.isAlphabetic(str.charAt(start))) {
                start++;
            } else if (!Character.isAlphabetic(str.charAt(end))) {
                end--;
            } else if (str.charAt(start) != str.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    /**
     * Q6 Reverse all words in a String
     */
    public static String reverseWords(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return "";
        reverse(chars, 0, chars.length);
        int start = 0, end;

        while ((end = find(chars, ' ', start)) != -1) {
            reverse(chars, start, end);
            start = end + 1;
        }
        reverse(chars, start, chars.length);
        return new String(chars);
    }

    public static int find(char[] str, char c, int start) {
        for (int i = start; i < str.length; i++) {
            if (c == str[i]) return i;
        }
        return -1;
    }

    public static void reverse(char[] str, int start, int stopIndex) {
        if (start >= stopIndex) {
            return;
        }
        int last = stopIndex - 1;
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char tmp = str[i];
            str[i] = str[last - i + start];
            str[last - i + start] = tmp;
        }
    }

    /**
     * Q7 Compute All Mnemonics for a phone number
     */
    private static final String[] MAPPING = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PORS", "TUV", "WXYZ"};

    private static List<String> phoneMnemonic(String phoneNumber) {
        char[] partialMnemonic = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicHelper(phoneNumber, 0, partialMnemonic, mnemonics);
        return mnemonics;
    }

    private static void phoneMnemonicHelper(String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics) {
        if (digit == phoneNumber.length()) {
            mnemonics.add(new String(partialMnemonic));
        } else {
            for (int i = 0; i < MAPPING[phoneNumber.charAt(digit) - '0'].length(); i++) {
                char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit] = c;
                phoneMnemonicHelper(phoneNumber, digit + 1, partialMnemonic, mnemonics);
            }
        }
    }

}
