package com.chefmic.linkedin.newQuestion;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

    //dfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphHelper(node, map);

    }

    private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        map.put(node.label, newnode);
        for (UndirectedGraphNode point : node.neighbors) {
            if (!map.containsKey(point.label)) {
                newnode.neighbors.add(cloneGraphHelper(point, map));
            }
        }
        return newnode;
    }

    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
