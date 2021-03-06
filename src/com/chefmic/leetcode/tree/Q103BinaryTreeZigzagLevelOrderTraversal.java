package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.*;

/**
 * Created by cyuan on 1/20/17.
 */
public class Q103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int numToProcess = queue.size();
        List<Integer> oneLevel = new ArrayList<>();

        boolean order = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            numToProcess--;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (numToProcess == 0) {
                numToProcess = queue.size();
                if (order) {
                    res.add(new ArrayList<>(oneLevel));
                } else {
                    Collections.reverse(oneLevel);
                    res.add(new ArrayList<>(oneLevel));
                }
                oneLevel.clear();
                order = !order;
            }
        }
        return res;
    }

    private void traverse(TreeNode node, int level, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        if (node.left != null) {
            traverse(node.left, level + 1, result);
        }

        if (node.right != null) {
            traverse(node.right, level + 1, result);
        }
    }

}
