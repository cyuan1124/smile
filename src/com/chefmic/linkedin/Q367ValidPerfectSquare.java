package com.chefmic.linkedin;

import org.junit.Test;

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
        assertTrue(isPerfectSquare(1));
        assertFalse(isPerfectSquare(3));
        assertTrue(isPerfectSquare(9));
        assertTrue(isPerfectSquare(16));
        assertTrue(isPerfectSquare(25));
    }

}
