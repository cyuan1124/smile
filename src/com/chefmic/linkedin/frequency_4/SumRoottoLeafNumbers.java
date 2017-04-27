package com.chefmic.linkedin.frequency_4;

import com.chefmic.leetcode.ds.TreeNode;

public class SumRoottoLeafNumbers {
    int res;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        sumNumbers(root, 0);
        return res;

    }

    public void sumNumbers(TreeNode root, int pathsum) {
        if (root.left == null && root.right == null) {
            res = res + pathsum * 10 + root.val;
        }
        if (root.left != null) {
            sumNumbers(root.left, pathsum * 10 + root.val);
        }
        if (root.right != null) {
            sumNumbers(root.right, pathsum * 10 + root.val);
        }
    }

}
