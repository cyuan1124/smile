package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.*;

/**
 * Created by cyuan on 12/31/16.
 */
public class Q94BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        for (int i : inorderTraversal(node1)) {
            System.out.println(i);
        }

    }

    enum State {Visited, Unvisited, Visiting}

    public static List<Integer> inorderTraversal(TreeNode root) {
        Map<TreeNode, State> stateMap = new HashMap<>();
        stateMap.put(root, State.Unvisited);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (stateMap.getOrDefault(node, State.Unvisited) == State.Visiting) {
                queue.remove(node);
                res.add(node.val);
                if (node.right != null) {
                    queue.addFirst(node.right);
                }
            } else {
                stateMap.put(node, State.Visiting);
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
            }
        }
        return res;
    }
}
