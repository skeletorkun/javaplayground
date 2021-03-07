package com.company.interviewcake;

import java.util.*;

public class GraphTraversal {

    /* Representation of a vertex */
    static class Node {
        int val;
        List<Node> children; // Edges in the graph to other vertices

        public Node() {
            children = new ArrayList<>();
        }
    }

    public static boolean bfs(Node start, int end) {

        HashSet<Node> visited = new HashSet<>();
        Queue<Node> nextToVisit = new LinkedList<>();

        nextToVisit.add(start);

        while(!nextToVisit.isEmpty()){

            Node current = nextToVisit.remove();
            if(visited.contains(current)){
                continue;
            }

            if(current.val == end){
                return true;
            }

            nextToVisit.addAll(current.children);

            visited.add(current);
        }

        return false;
    }

    /**
     *
     * use a stack, without recursion
     * https://www.baeldung.com/java-depth-first-search
     * @param start
     * @param end
     * @return
     */
    public static boolean dfsWithStack(Node start, int end) {

        HashSet<Node> visited = new HashSet<>();
        Stack<Node> nextToVisit = new Stack<>();

        nextToVisit.add(start);

        while(!nextToVisit.isEmpty()){
            Node current = nextToVisit.pop();
            if(current.val == end){
                return true;
            }
            if(visited.contains(current)){
                continue;
            }
            for (Node child : current.children){
                nextToVisit.add(child);
            }
            visited.add(current);
        }
        return false;
    }

    public static void Main(String[] args) {

    }

}
