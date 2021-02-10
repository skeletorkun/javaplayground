package com.company.trees;

import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestor {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {

        if(root.data > v1 && root.data < v2){
            return root;
        }
        else if(root.data > v1){
            return lca(root.left, v1, v2);
        }
        else{
            return lca(root.right, v1, v2);
        }
    }



    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }


    public static void main(String[] args) {

        Node root = null;
        List<Integer> integers = Arrays.asList(4, 2, 3, 1, 7, 6);
        for(int i : integers){
            root = insert(root, i);
        }

        Node ans = lca(root, 1, 3);
        System.out.println(ans.data);

    }
}
