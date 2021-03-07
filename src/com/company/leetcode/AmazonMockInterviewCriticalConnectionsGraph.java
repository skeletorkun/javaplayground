package com.company.leetcode;

import com.company.Main;

import java.util.*;
import java.util.stream.Collectors;

public class AmazonMockInterviewCriticalConnectionsGraph {


    class Node {
        int v;
        Map<Integer, Node> neighbors = new HashMap<>();

        public Node(Integer val) {
            this.v = val;
        }

        @Override
        public String toString() {
           return  v + " --> " + neighbors.values().stream().map(n -> n.v).collect(Collectors.toList());
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // build map
        Map<Integer, Node> nodes = new HashMap<>();
        for (List<Integer> connection : connections) {

            Integer from = connection.get(0);
            Integer to = connection.get(1);

            Node fromNode = nodes.getOrDefault(from, new Node(from));
            Node toNode = nodes.getOrDefault(to, new Node(to));

            fromNode.neighbors.put(to, toNode);
            toNode.neighbors.put(from, fromNode);

            nodes.put(from, fromNode);
            nodes.put(to, toNode);
        }

        println("Nodes are now ");
        nodes.values().forEach(x -> println(x));

        // check with bfs
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> connection : connections){
            println("checking connection " + connection);

            if(!checkWithBFS(nodes.get(connection.get(0)), connection.get(1), n)){
                res.add(connection);
            }
        }

        return res;
    }

    private boolean checkWithBFS(Node start, int forbidden, int totalNodes) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for (Node neighbor : current.neighbors.values()){
                if(!visited.contains(neighbor.v)){
                    if(!(neighbor.v == forbidden && current.v == start.v)){
                        queue.add(neighbor);
                    }
                }
            }
            println("visiting " + current.v);
            visited.add(current.v);
        }

        return totalNodes == visited.size();
    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {
        AmazonMockInterviewCriticalConnectionsGraph solution = new AmazonMockInterviewCriticalConnectionsGraph();

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        println(solution.criticalConnections(4, connections));
    }
}
