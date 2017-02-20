package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cyuan on 2/19/17.
 */
public class Q314BinaryTreeVerticalOrderTraversal {

    class Event {
        final TreeNode node;
        final int index;

        public Event(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Event> queue = new LinkedList<>();
        queue.offer(new Event(root, 0));
        while (!queue.isEmpty()) {
            Event event = queue.poll();
            if (event.node == null) continue;
            if (!map.containsKey(event.index)) {
                map.put(event.index, new ArrayList<>());
            }
            map.get(event.index).add(event.node.val);
            if (event.node.left != null) {
                queue.offer(new Event(event.node.left, event.index - 1));
            }
            if (event.node.right != null) {
                queue.offer(new Event(event.node.right, event.index + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int key : map.keySet().stream().sorted().collect(Collectors.toList())) {
            result.add(map.get(key));
        }
        return result;
    }

    private void traverse(TreeNode root, int x, Map<Integer, List<Integer>> map) {
        if (root == null) return;
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(root.val);
        traverse(root.left, x - 1, map);
        traverse(root.right, x + 1, map);
    }

}
