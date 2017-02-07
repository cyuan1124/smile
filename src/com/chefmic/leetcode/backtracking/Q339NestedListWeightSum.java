package com.chefmic.leetcode.backtracking;

import com.chefmic.leetcode.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/3/17.
 */
public class Q339NestedListWeightSum {

    public static void main(String[] args) {
        Q339NestedListWeightSum tester = new Q339NestedListWeightSum();
        List<NestedInteger> nestedIntegerList = new ArrayList<>();
        List<NestedInteger> list1 = new ArrayList<>();
        list1.add(new NestedInteger(1));
        list1.add(new NestedInteger(1));

        nestedIntegerList.add(new NestedInteger(list1));
        nestedIntegerList.add(new NestedInteger(2));
        nestedIntegerList.add(new NestedInteger(list1));

        System.out.print(tester.depthSum(nestedIntegerList));

    }

    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 0;
        for (NestedInteger nest : nestedList) {
            depth += depth(nest, 0);
        }
        return depth;
    }

    private int depth(NestedInteger nest, int depth) {
        if (nest.isInteger()) {
            return nest.getInteger() * (depth + 1);
        } else {
            int sum = 0;
            for (NestedInteger item : nest.getList()) {
                sum += depth(item, depth + 1);
            }
            return sum;
        }
    }

}
