package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 3/25/17.
 */
public class Q98ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        assertTrue(isValidBST(root));
    }

}
