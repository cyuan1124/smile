package com.chefmic.leetcode.list;

import java.util.*;

/**
 * Created by cyuan on 4/23/17.
 */
public class UnionAndIntersection<T> {

    private List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<>(set);
    }

    private List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new LinkedList<>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

}
