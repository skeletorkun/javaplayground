package com.company.leetcode;

import com.company.Main;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        return visit(root);
    }

    public static int visit(TreeNode node) {


        "stuff".chars().mapToObj(i -> (char)i).collect(Collectors.toList());
        if (node == null) {
            return 0;
        }

        int left = 1 + visit(node.left);
        int right = 1 + visit(node.right);

        return Math.max(left, right);
    }


    public static void main(String[] args) {

        BinaryTree solution = new BinaryTree();

        char c = '\u00a5';
        char c2 = 12332;
        String s = "¥es!";

        Main.println("stuff".chars().mapToObj(i -> (char)i).collect(Collectors.toList()));
        Main.println(Arrays.toString(s.toCharArray()));
        Main.println((int)c);
        Main.println((int)c2);
//        Main.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}
