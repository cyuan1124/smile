package com.chefmic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 1/17/17.
 */
public class NestedInteger {

    private Integer integer;

    private List<NestedInteger> list;

    public NestedInteger(Integer integer, List<NestedInteger> list) {
        this.integer = integer;
        this.list = list;
    }

    public NestedInteger(Integer integer) {
        this.integer = integer;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.integer = null;
        this.list = list;
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public void setInteger(int value) {
        this.integer = value;
    }

    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(ni);
    }
}
