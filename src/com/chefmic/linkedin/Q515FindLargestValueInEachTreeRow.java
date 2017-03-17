package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

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



}
