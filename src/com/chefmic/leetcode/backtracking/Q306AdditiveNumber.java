package com.chefmic.leetcode.backtracking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q306AdditiveNumber {

    /**
     * 112358 -> 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * 199100199 -> 1 + 99 = 100, 99 + 100 = 199
     */
    public boolean isAdditiveNumber(String num) {
        // We only need to find the first and second number, then simply test if remaining numbers work
        // Since there are at least 3 numbers in such series, the maximum length of first and second number
        // is no more than num.length() / 2
        for (int i = 1; i < num.length() / 2 + 1; i++) {
            for (int j = 1; j < num.length() / 2 + 1; j++) {
                long num1 = Long.valueOf(num.substring(0, i));
                long num2 = Long.valueOf(num.substring(i, i + j));
                if (validate(num1, num2, num)) return true;
            }
        }

        return false;
    }

    public boolean validate(long num1, long num2, String num) {
        StringBuilder expect = new StringBuilder();
        long tmpSum = 0;
        expect.append(num1);
        expect.append(num2);
        do {
            tmpSum = num1 + num2;
            expect.append(tmpSum);
            num1 = num2;
            num2 = tmpSum;
        } while (expect.length() < num.length());
        return num.equals(expect.toString());
    }

    @Test
    public void testValidateAddictiveNum() {
        String _112358 = "112358";
        assertEquals(true, validate(1, 1, _112358));

        assertEquals(true, isAdditiveNumber("123"));
    }

}
