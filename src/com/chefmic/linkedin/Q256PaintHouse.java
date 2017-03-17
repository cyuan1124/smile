package com.chefmic.linkedin;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q256PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[][] prices = new int[costs.length][3];
        prices[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            prices[i][0] = costs[i][0] + Math.min(prices[i - 1][1], prices[i - 1][2]);
            prices[i][1] = costs[i][1] + Math.min(prices[i - 1][0], prices[i - 1][2]);
            prices[i][2] = costs[i][2] + Math.min(prices[i - 1][0], prices[i - 1][1]);
        }
        return Math.max(Math.max(prices[costs.length - 1][0], prices[costs.length - 1][1]),
                prices[costs.length - 1][2]);
    }

}
