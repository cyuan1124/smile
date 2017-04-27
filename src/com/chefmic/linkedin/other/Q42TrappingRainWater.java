package com.chefmic.linkedin.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 4/22/17.
 */
public class Q42TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0;
        int i = 0;
        while (i < height.length && height[i] == 0) {
            i++;
        }

        while (i < height.length) {
            int start = height[i];
            int j = i + 1;
            int tmp = 0;
            while (j <= height.length && height[j - 1] <= start) {
                tmp += (start - height[j++ - 1]);
            }
            if (j < height.length) {
                sum += tmp;
            }
            i = j;
        }

        return sum;
    }

    @Test
    public void test() {
        assertEquals(3, trap(new int[]{2, 1, 0, 2}));
    }

}
