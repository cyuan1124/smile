package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.Arrays;

/**
 * Created by cyuan on 1/20/17.
 */
public class Q105PreorderInorder {

    public static void main(String[] args) {
        System.out.println(1 << 1 - 1);
    }

    public static int findComplement(int num) {
        return (num & (num - 1)) & (~num);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preS > preE || inS > inE) return null;
        TreeNode root = new TreeNode(pre[preS]);

        int rootIndex = index(in, root.val);

        root.left = build(pre, preS + 1, preS + (rootIndex - inS), in, inS, rootIndex - 1);
        root.right = build(pre, preS + (rootIndex - inS) + 1, preE, in, rootIndex + 1, inE);

        return root;
    }

    private int index(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) return i;
        }
        throw new AssertionError("Invalid Val " + val);
    }

}
