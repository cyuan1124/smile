package com.chefmic.linkedin.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cyuan on 4/13/17.
 */
public class Q518CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] res = new int[amount + 1];
        Arrays.sort(coins);
        for (int coin : coins) {
            res[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= coin) {
                    res[i] += res[i - coin];
                }
            }
        }
        return res[amount];
    }

    @Test
    public void test() {
        System.out.println(change(5, new int[]{1,2,5}));
    }

}
