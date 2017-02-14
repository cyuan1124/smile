package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q250CountUnivalueSubtrees {

    class State {
        int value;
        boolean same;

        public State(int value, boolean same) {
            this.value = value;
            this.same = same;
        }
    }

    int count;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        traverse(root);
        return count;
    }

    State traverse(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            count++;
            return new State(node.val, true);
        }

        State left = traverse(node.left);
        State right = traverse(node.right);

        if (left == null) left = new State(node.val, true);
        if (right == null) right = new State(node.val, true);

        if (left.same && right.same && node.val == left.value && left.value == right.value) {
            count++;
            return new State(node.val, true);
        }
        return new State(-1, false);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        assertEquals(4, countUnivalSubtrees(root));
    }

}
