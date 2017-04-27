package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.*;

/**
 * Created by cyuan on 3/17/17.
 */
public class Q515FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, 1, res);
        return res;
    }

    private void traverse(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;
        if (level > res.size()) {
            res.add(node.val);
        } else {
            if (node.val > res.get(level - 1)) {
                res.set(level - 1, node.val);
            }
        }
        if (node.left != null) {
            traverse(node.left, level + 1, res);
        }
        if (node.right != null) {
            traverse(node.right, level + 1, res);
        }
    }

    private List<Integer> findLargest(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            res.add(queue.stream().max(Comparator.comparingInt(n -> n.val)).get().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }



}
