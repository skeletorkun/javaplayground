package com.company.trees;

public class CheckBalanced {

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean isTreeBalanced(Node root) {

        return isSubTreeBalanced(root);

    }

    private boolean isSubTreeBalanced(Node node) {

        if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) {
            return false;
        }

        return isSubTreeBalanced(node.right) && isSubTreeBalanced(node.left);
    }

    private int getHeight(Node node) {

        if (node == null) {
            return -1;
        }
        else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }


}
