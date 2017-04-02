package com.chefmic.linkedin.other;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers, how many three numbers can be found in the array,
 * so that we can build an triangle whose three edges length is the three numbers that we find?
 * <p>
 * Given array S = [3,4,6,7], return 3. They are:
 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 * <p>
 * Given array S = [4,4,4,4], return 4. They are:
 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 */
public class TriangleCount {

    public int triangleCount(int S[]) {
        Arrays.sort(S);
        int counter = 0;
        int left = 0, right = S.length - 1;
        for (int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    counter = counter + (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(3, triangleCount(new int[]{3, 4, 6, 7}));
        assertEquals(4, triangleCount(new int[]{4, 4, 4, 4}));
    }

}