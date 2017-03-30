package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cyuan on 3/17/17.
 */
public class Q103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> vals = queue.stream().map(node -> node.val).collect(Collectors.toList());
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (level % 2 == 1) {
                Collections.reverse(vals);
            }
            res.add(vals);
            level++;
        }
        return res;
    }

}
