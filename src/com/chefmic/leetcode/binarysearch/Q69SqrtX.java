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

    public double squareRoot(double x) {
        double left, right;
        if (x < 1) {
            left = x;
            right = 1.0;
        } else {
            left = 1.0;
            right = x;
        }

        while (compare(left, right) == Ordering.SMALLER) {
            double mid = left + 0.5 * (right - left);
            double midSquare = mid * mid;
            if (compare(midSquare, x) == Ordering.EQUAL) {
                return mid;
            } else if (compare(midSquare, x) == Ordering.SMALLER) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    enum Ordering {
        SMALLER, EQUAL, LAGER
    }

    private Ordering compare(double a, double b) {
        final double EPSILON = 0.00001;
        double diff = (a - b) / b;
        return diff < -EPSILON ? Ordering.SMALLER :
                (diff > EPSILON ? Ordering.LAGER : Ordering.EQUAL);
    }

}
