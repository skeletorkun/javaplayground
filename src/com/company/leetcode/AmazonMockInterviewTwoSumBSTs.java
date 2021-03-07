package com.company.leetcode;

import java.util.*;

public class AmazonMockInterviewTwoSumBSTs {
    public class TreeNode {
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

    class Tuple {
        TreeNode node;
        int target;

        public Tuple(TreeNode n, int t) {
            node = n;
            target = t;
        }
    }

    List<Integer> values = new ArrayList<>();

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (searchOtherTree(root2, target - node.val)) return true;

            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);

        }
        return false;
    }

    private boolean searchOtherTree(TreeNode root, int target) {

        if (values.isEmpty()) {
            // fill once
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                values.add(node.val);

                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);

            }
        }

        return values.contains(target);
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        AmazonMockInterviewTwoSumBSTs solution = new AmazonMockInterviewTwoSumBSTs();
//        println(Arrays.toString(solution.arrayRankTransform(new int[]{40, 10, 20, 30})));
    }
}
