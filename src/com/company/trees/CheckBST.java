package com.company.trees;

public class CheckBST {

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean isBST(Node node) {

        if (node == null) {
            return true;
        }

        // in order traversal
        boolean leftCheck = node.left != null && node.left.data > node.data;
        boolean rightCheck = node.right != null && node.data >= node.right.data;
        if (!leftCheck || !rightCheck) {
            return false;
        }

        return isBST(node.left) && isBST(node.right);
    }
}
