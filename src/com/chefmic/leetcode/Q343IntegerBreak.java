package com.chefmic.leetcode;

/**
 * Created by cyuan on 12/31/16.
 */
public class Q343IntegerBreak {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(integerBreak(i));
        }
    }

    public static int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }

}
