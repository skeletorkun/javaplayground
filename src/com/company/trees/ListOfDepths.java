package com.company.trees;

import com.company.leetcode.LinkedListSolution;

import java.util.*;

public class ListOfDepths {

    /* Hidden stub code will pass a root argument to the function below.
     * Complete the function to solve the challenge.
     * Hint: you may want to write one or more helper functions.
     */


    class Graph {
        List<Node> nodeList;

    }

    class Node {
        int data;
        Node left;
        Node right;
    }

    void listOfDepths(Node root) {

        Map<Integer, LinkedList<Node>> levels = new HashMap<>();
        traversePreOrder(levels, root, 0);

    }

    private void traversePreOrder(Map<Integer, LinkedList<Node>> levels, Node node, int level) {

        if(node == null){
            return;
        }

        levels.getOrDefault(level, new LinkedList<>()).add(node);

        traversePreOrder(levels, node.left, level + 1);
        traversePreOrder(levels, node.right, level + 1);
    }


}
