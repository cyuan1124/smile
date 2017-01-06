package com.chefmic.crack;

import com.chefmic.crack.ds.*;

import java.util.*;

/**
 * Created by cyuan on 12/31/16.
 */
public class Ch4TreesAndGraphs {

    /**
     * Q1. Route Between Nodes
     * <p>
     * Given a directed graph, design an algorithm to find out whether
     * there is a route between two nodes.
     * <p>
     * Use Breadth First Search to solve this problem.
     */
    enum State {
        Unvisited, Visited, Visiting
    }

    public boolean isConnected(Graph graph, Node start, Node end) {
        if (graph == null || start == null || end == null) {
            return false;
        }
        if (start == end) return true;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, State> nodeStateMap = new HashMap<>();
        for (Node node : graph.nodes) {
            nodeStateMap.put(node, State.Unvisited);
        }
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node n : node.children) {
                if (n == end) return true;
                if (nodeStateMap.get(n) == State.Unvisited) {
                    nodeStateMap.put(n, State.Visiting);
                    queue.offer(n);
                }
            }
            nodeStateMap.put(node, State.Visited);
        }
        return false;
    }

    /**
     * Q2. Minimal Tree
     * <p>
     * Given a sorted array with unique integer elements,
     * write an algorithm to create a binary search tree with minimal height.
     */
    public BTNode constructBST(int[] values) {
        return constructBST(values, 0, values.length - 1);
    }

    public BTNode constructBST(int[] values, int start, int end) {
        if (start > end) return null;
        BTNode root = new BTNode(values[(start + end) / 2]);
        root.left = constructBST(values, start, (start + end) / 2 - 1);
        root.right = constructBST(values, (start + end) / 2 + 1, end);
        return root;
    }

    /**
     * Q3. List of depths
     * <p>
     * Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth.
     * (e.g, if you have a tree with depth D, you'll have D linked lists.
     */
    public List<List<BTNode>> createListOfDepths(BTNode root) {
        List<List<BTNode>> res = new ArrayList<>();
        createListOfDepths(root, res, 0);
        return res;
    }

    private void createListOfDepths(BTNode root, List<List<BTNode>> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root);
        createListOfDepths(root.left, res, level + 1);
        createListOfDepths(root.right, res, level + 1);
    }

    /**
     * Q4. Check Balanced
     * Implement a function to check if a binary tree is balanced.
     */
    public boolean isBalanced(BTNode root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(BTNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private int checkHeight(BTNode root) {
        if (root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Q5. Validate Binary Search Tree
     * Implement a function to check if a binary tree is a BST
     */
    public boolean validateBinarySearchTree(BTNode root) {
        return false;
    }
}
