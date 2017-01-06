package com.chefmic.crack.ds;

/**
 * Created by cyuan on 12/31/16.
 */
public class Node {

    public String name;
    public Node[] children;

    public Node(String name, Node[] children) {
        this.name = name;
        this.children = children;
    }

}
