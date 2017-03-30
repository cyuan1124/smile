package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
