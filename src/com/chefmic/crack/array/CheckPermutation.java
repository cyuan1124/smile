package com.chefmic.crack.array;

import java.util.Arrays;

/**
 * Created by cyuan on 4/14/17.
 */
public class CheckPermutation {

    private boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = sort(str1);
        str2 = sort(str2);

        return str1.equals(str2);

    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
