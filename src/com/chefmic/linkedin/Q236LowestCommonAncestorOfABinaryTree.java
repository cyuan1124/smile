package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;

/**
 * Created by cyuan on 3/17/17.
 */
public class Q236LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p, q).node;
    }

    class State {
        int numOfFound;
        TreeNode node;

        public State(int numOfFound, TreeNode node) {
            this.numOfFound = numOfFound;
            this.node = node;
        }
    }

    private State findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new State(0, null);
        }

        State left = findAncestor(root.left, p, q);
        if (left.numOfFound == 2) {
            return left;
        }

        State right = findAncestor(root.right, p, q);
        if (right.numOfFound == 2) {
            return right;
        }

        int numOfFound = left.numOfFound + right.numOfFound +
                (root == p ? 1 : 0) + (root == q ? 1 : 0);
        return new State(numOfFound, root);
    }

}
