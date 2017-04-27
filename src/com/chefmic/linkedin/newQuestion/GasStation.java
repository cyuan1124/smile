package com.chefmic.linkedin.newQuestion;
//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
//Note:
//The solution is guaranteed to be unique. 

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int sum = 0;
        int total = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            total = total + gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }

        if (total < 0) {
            return -1;
        }
        return index + 1;
    }

}
