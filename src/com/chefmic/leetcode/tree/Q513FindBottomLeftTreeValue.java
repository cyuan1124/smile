package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cyuan on 2/13/17.
 */
public class Q513FindBottomLeftTreeValue {

    int deepest = 0;

    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> level = new ArrayList<TreeNode>();
        traverse(root, level, 0);
        return level.get(0).val;
    }

    private void traverse(TreeNode root, List<TreeNode> level, int height) {
        if (root == null) return;
        if (height >= deepest) {
            if (height > deepest) {
                level.clear();
            }
            deepest = height;
            level.add(root);
        }
        traverse(root.left, level, height + 1);
        traverse(root.right, level, height + 1);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        System.out.println(findBottomLeftValue(root));
    }

}
