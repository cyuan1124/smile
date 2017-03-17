package com.chefmic.linkedin;

import com.chefmic.leetcode.NestedInteger;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q364NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Deque<NestedInteger>  deque = new LinkedList<>(nestedList);
        boolean allInteger = false;
        int sum = 0;
        do {
            allInteger = true;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                NestedInteger integer = deque.pop();
                allInteger &= integer.isInteger();
                if (integer.isInteger()) {
                    sum += integer.getInteger();
                    deque.offerLast(integer);
                } else {
                    for (NestedInteger nestedInteger : integer.getList()) {
                        deque.offerLast(nestedInteger);
                    }
                }
            }
        } while (!allInteger);
        return sum;
    }

}
