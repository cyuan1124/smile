package com.chefmic.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cyuan on 4/8/17.
 */
public class Q202HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = getSum(n);
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    @Test
    public void test() {
        isHappy(2);
    }

}
