package com.chefmic.linkedin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 3/15/17.
 */
public class Q367ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i+= 2;
        }
        return num == 0;
    }

    @Test
    public void test() {
        assertTrue(isPerfectSquare2(9));
        assertTrue(isPerfectSquare2(16));
        assertTrue(isPerfectSquare2(25));
    }

    public boolean isPerfectSquare2(int num) {
        if (num < 1) {
            return false;
        }

        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num / mid == mid) {
                return true;
            } else if (num / mid < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
