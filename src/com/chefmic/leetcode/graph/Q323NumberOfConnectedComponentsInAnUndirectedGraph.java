package com.chefmic.leetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cyuan on 2/4/17.
 */
public class Q323NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        Q323NumberOfConnectedComponentsInAnUndirectedGraph tester = new Q323NumberOfConnectedComponentsInAnUndirectedGraph();
        int[][] edges = new int[][] { {2,0}, {2, 1}};
        System.out.println(tester.countComponents(3, edges));
    }

    public int countComponents(int n, int[][] edges) {
        int[] head = new int[n];
        for (int i = 0; i < n; i++) {
            head[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int origin = Math.min(edge[0], edge[1]);
            origin = Math.min(origin, head[edge[0]]);
            origin = Math.min(origin, head[edge[1]]);
            head[edge[0]] = origin;
            head[edge[1]] = origin;
        }

        Set<Integer> origins = new HashSet<>();
        for (int node : head) {
            origins.add(findOrigin(head, node));
        }
        return origins.size();
    }

    private int findOrigin(int[] heads, int node) {
        while (node != heads[node]) {
            node = heads[node];
        }
        return node;
    }

}
