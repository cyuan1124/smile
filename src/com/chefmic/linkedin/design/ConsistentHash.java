package com.chefmic.linkedin.design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cyuan on 3/21/17.
 */
public class ConsistentHash {

    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        List<List<Integer>> machines = new ArrayList<>();
        int start = 0, end = 359;
        if (n == 0) return machines;

        machines.add(Arrays.asList(start, end, 1));

        for (int i = 2; i <= n; i++) {
            int max = -1, index = -1;
            for (int j = 0; j < machines.size(); j++) {
                if (machines.get(j).get(1) - machines.get(j).get(0) > max) {
                    max = machines.get(j).get(1) - machines.get(j).get(0);
                    index = j;
                }
            }
            // Machine J has the most
            List<Integer> maxMachine = machines.get(index);
            List<Integer> newMachine = Arrays.asList(maxMachine.get(0) + (maxMachine.get(1) - maxMachine.get(0)) / 2 + 1,
                    maxMachine.get(1), machines.size() + 1);
            maxMachine = Arrays.asList(maxMachine.get(0),
                    maxMachine.get(0) + (maxMachine.get(1) - maxMachine.get(0)) / 2,
                    maxMachine.get(2));
            if (index < machines.size()) {
                machines.add(index + 1, newMachine);
            } else {
                machines.add(newMachine);
            }

            machines.set(index, maxMachine);
        }

        return machines;
    }

    @Test
    public void test() {
        consistentHashing(2).stream().forEach(
                list -> System.out.println(String.format("[%d %d %d]", list.get(0), list.get(1), list.get(2))));
    }

}
