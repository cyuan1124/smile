package com.chefmic.elements.bst;

import java.util.TreeSet;

/**
 * Created by cyuan on 2/4/17.
 */
public class TreeSetTreeMap {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(9);
        set.add(11);

        System.out.println(set.ceiling(3));
        System.out.println(set.floor(3));
        System.out.println(set.headSet(4));
        System.out.println(set.tailSet(4, false));
        System.out.println(set.higher(4));
        System.out.println(set.lower(4));
    }

}
