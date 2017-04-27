package com.chefmic.linkedin.frequency_5;


// Assume a BST is defined as follows:
//
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.

import com.chefmic.leetcode.ds.TreeNode;

public class ValidateBST {

    static int lastVisit = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        root.left = left;
        System.out.print((new ValidateBST()).isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= lastVisit) {
            return false;
        }
        lastVisit = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;

    }

}