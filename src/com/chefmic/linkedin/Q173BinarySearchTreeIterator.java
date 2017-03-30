package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.Stack;

/**
 * Created by cyuan on 3/17/17.
 */
public class Q173BinarySearchTreeIterator {

    class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            addTreeNode(root);
        }

        private void addTreeNode(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            addTreeNode(node.right);
            return node.val;
        }
    }


}
