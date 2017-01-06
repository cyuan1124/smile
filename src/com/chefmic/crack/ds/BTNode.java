package com.chefmic.crack.ds;

/**
 * Created by cyuan on 12/31/16.
 */
public class BTNode {

    public int value;
    public BTNode left, right;

    public BTNode(int value, BTNode left, BTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BTNode(int value) {
        this.value = value;
    }
}
