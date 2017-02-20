package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 2/18/17.
 */
public class Q356LineReflection {

    public boolean isReflected(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) return Integer.compare(p1[0], p2[0]);
                return Integer.compare(p1[1], p2[1]);
            }
        });

        int pivot = points[points.length - 1][0] + points[0][0];
        for (int i = 0; i < points.length / 2 + 1; i++) {
            int endIndex = points.length - 1 - i;
            if (points[i][1] != points[endIndex][1] || points[i][0] + points[endIndex][0] != pivot) return false;
        }
        return true;
    }

    @Test
    public void test() {
        int[][] points = new int[][]{{1, 1}, {0, 0}, {-1, 1}};
        assertTrue(isReflected(points));
        points = new int[][]{{1, 1}, {-1, -1}};
        assertFalse(isReflected(points));
    }

}
