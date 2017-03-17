package com.chefmic.smile.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Q66PlusOne {

    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry) {
                carry = (digits[i] == 9);
                digits[i] = (digits[i] + 1) % 10;
            }
        }
        if (carry) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(plusOne(new int[] {1, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[] {9, 9, 9, 9})));
    }

}
