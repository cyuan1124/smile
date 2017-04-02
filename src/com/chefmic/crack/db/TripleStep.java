package com.chefmic.crack.db;

import org.junit.Test;

/**
 * A kid running up stairs and can hop 1, 2 and 3 steps
 */
public class TripleStep {

    public int steps(int n) {
        int[] steps = new int[n];
        steps[0] = 0;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = (i >= 2 ? 1 + steps[i - 1] + steps[i - 2] : 0)
                    + (i >= 3 ? 1 + steps[i - 1] + steps[i - 2] + steps[i - 3] : 0)
                    + (1 + steps[ i - 1]);
        }

        return steps[n];
    }

    private int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    @Test
    public void test() {

    }

}
