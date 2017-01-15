package com.chefmic.leetcode.array;

import java.util.Arrays;

/**
 * Created by cyuan on 1/2/17.
 */
public class Q74SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        Q74SearchA2DMatrix tester = new Q74SearchA2DMatrix();
        System.out.println(tester.searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int arrayIndex = findArrayIndex(matrix, target);
        if (arrayIndex < 0) {
            int insertIndex = -arrayIndex - 1;
            if (insertIndex == 0) {
                return false;
            } // Smaller than the smallest}
            arrayIndex = insertIndex - 1; // Search in the last row
        }
        System.out.println("Searching in row " + arrayIndex);
        return Arrays.binarySearch(matrix[arrayIndex], target) >= 0;
    }

    private int findArrayIndex(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = matrix[mid][0];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // target found
        }
        return -(low + 1);  // target not found.
    }

}
