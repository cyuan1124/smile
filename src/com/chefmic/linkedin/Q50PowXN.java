package com.chefmic.linkedin;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q50PowXN {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else if (n < 0) {
            return result * result / x;
        }
        return result * result * x;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }

}
