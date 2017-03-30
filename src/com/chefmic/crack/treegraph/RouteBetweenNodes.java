package com.chefmic.crack.treegraph;

import com.chefmic.crack.ds.Graph;
import com.chefmic.crack.ds.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out
 * whether there is a route between two nodes
 */
public class RouteBetweenNodes {

    public boolean search(Graph graph, Node start, Node end) {
        if (start == end) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node, State> stats = new HashMap<>();
        for (Node node : graph.nodes) {
            stats.put(node, State.Unvisited);
        }
        stats.put(start, State.Visited);
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                for (Node n : node.children) {
                    if (stats.get(n) == State.Unvisited) {
                        if (n == end) {
                            return true;
                        } else {
                            stats.put(n, State.Visiting);
                            queue.offer(n);
                        }
                    }
                }
                stats.put(node, State.Visited);
            }
        }

        return false;
    }

    private enum State {
        Visited, Visiting, Unvisited;
    }


}
