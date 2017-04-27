package com.chefmic.linkedin.newQuestion;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.ArrayList;

public class BinaryTreePreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }


}