package com.chefmic.leetcode.binarysearch;

/**
 * Created by cyuan on 1/17/17.
 */
public class Q69SqrtX {

    public static void main(String[] args) {
        System.out.println(1 + 0 >> 2);
        System.out.print(mySqrt(1));
    }

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + ((right - left) >> 2);
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid + 1 > x / (mid + 1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
    }
}
