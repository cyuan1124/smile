package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 */
public class Q156BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        TreeNode newRoot = stack.pop();
        node = newRoot;
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            node.right = n;
            node.left = n.right;
            node = n;
        }
        node.left = null;
        node.right = null;
        return newRoot;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root = upsideDownBinaryTree(root);

        while (root != null) {
            System.out.println(root.val);
            if (root.left != null) {
                System.out.println(root.left.val);
            }
            root = root.right;
        }

    }
}
