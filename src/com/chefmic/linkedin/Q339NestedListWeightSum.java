package com.chefmic.linkedin;

import com.chefmic.leetcode.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class Q339NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += i.getInteger() * level;
            } else {
                sum += depthSum(i.getList(), level + 1);
            }
        }
        return sum;
    }

    public int depthSum2(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }

        int sum = 0;
        int level = 1;

        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();

                if (ni.isInteger()) {
                    sum += ni.getInteger() * level;
                } else {
                    queue.addAll(ni.getList());
                }
            }

            level++;
        }

        return sum;
    }

}
