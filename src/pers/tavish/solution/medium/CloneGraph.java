package pers.tavish.solution.medium;

/*
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.


Note:

    - The number of nodes will be between 1 and 100.
    - The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
    - Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
    - You must return the copy of the given node as a reference to the cloned graph.

for more information: https://leetcode.com/problems/clone-graph/description/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return helper(node, new HashMap<>());
    }

    private Node helper(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(helper(neighbor, map));
        }
        return clone;
    }
}
