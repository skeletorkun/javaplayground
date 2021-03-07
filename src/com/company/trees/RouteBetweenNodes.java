package com.company.trees;

import java.util.*;

public class RouteBetweenNodes {

    /* Hidden stub code will pass a root argument to the function below.
     * Complete the function to solve the challenge.
     * Hint: you may want to write one or more helper functions.
     */


    class Graph {
        List<Node> nodeList;

    }

    class Node {
        int data;
        Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return data == node.data && next.equals(node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    boolean checkRoute(Graph g, Node begin, Node end) {

        Map<Node, Boolean> visited = new HashMap<>();


        // BFS with a Queue
        Queue<Node> toVisit = new LinkedList<>();

        toVisit.add(begin);
        while(!toVisit.isEmpty()){
            Node current = toVisit.poll();

            if(visited.containsKey(current)){
                continue;
            }

            if(current.data == end.data){
                return true;
            }

            visited.put(current, true);
            toVisit.add(current.next);
        }

        return false;

    }


}
