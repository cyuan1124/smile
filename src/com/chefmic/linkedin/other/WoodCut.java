package com.chefmic.linkedin.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cyuan on 4/3/17.
 */
public class WoodCut {

    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     *           return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        Arrays.sort(L);
        int max = L[0];
        // find the largest length that can cut more than k pieces of wood.
        int start = 1, end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (count(L, end) >= k) {
            return end;
        }
        if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int count(int[] L, int length) {
        int total = 0;
        for (int log : L) {
            total += log / length;
        }
        return total;
    }

    @Test
    public void test() {
        System.out.println(woodCut(new int[]{232, 124, 456}, 7));
    }
}
