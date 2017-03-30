package com.chefmic.crack.treegraph;

import com.chefmic.leetcode.ds.TreeNode;

/**
 * Create a binary search tree with minimal height
 */
public class MinimalTree {

    TreeNode createMinimalBST(int[] array) {
        return createMinimalBSL(array, 0, array.length - 1);
    }

    private TreeNode createMinimalBSL(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = createMinimalBSL(array, start, mid - 1);
        root.right = createMinimalBSL(array, mid + 1, end);
        return root;
    }

}
