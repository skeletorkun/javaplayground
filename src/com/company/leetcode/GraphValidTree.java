package com.company.leetcode;

import com.company.Main;

import java.util.*;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        if (n == 1) return true;

        Map<Integer, Node> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            Node fromNode = graph.getOrDefault(from, new Node());
            Node toNode = graph.getOrDefault(to, new Node());

            fromNode.val = from;
            toNode.val = to;

            fromNode.neighbors.add(toNode);
            toNode.neighbors.add(fromNode);

            graph.put(from, fromNode);
            graph.put(to, toNode);
        }

        if (n > graph.size()) return false; // there is an island

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(graph.values().iterator().next());

        Set<Node> visitedNodes = new HashSet<>();
        while (!deque.isEmpty()) {
            Node current = deque.pop();
            if (current.isVisited) return false;
            current.neighbors.forEach(x ->
            {
                x.neighbors.remove(current);
                deque.push(x);
            });
            current.isVisited = true;
            visitedNodes.add(current);
        }

        if(visitedNodes.size() != n){
            return false;
        }

        return true;
    }


    static class Node {
        boolean isVisited = false;
        int val;
        List<Node> neighbors = new ArrayList<>();
    }

    public static void main(String[] args) {
        GraphValidTree i = new GraphValidTree();

        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3}, {1, 4}, {1,3}
        };

        Main.println(i.validTree(5, edges));
    }

}
