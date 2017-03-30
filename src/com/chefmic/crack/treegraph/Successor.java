package com.chefmic.crack.treegraph;

import com.chefmic.leetcode.ds.TreeNode;

/**
 * Created by cyuan on 3/27/17.
 */
public class Successor {

    private TreeNode findSuccessor(TreeNode root, TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            while (node.left != null) {
                node = root.left;
            }
            return node;
        }

        // Search this treenode from root
        return null;
    }

}
