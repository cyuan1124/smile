package com.chefmic.linkedin.newQuestion;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.ArrayList;

public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
