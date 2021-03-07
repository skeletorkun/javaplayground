package com.company.leetcode;

import com.company.Main;

import java.util.Arrays;
import java.util.Stack;

public class LinkedListSolution {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }


    public static ListNode reverseList(ListNode current) {

        if(current == null) return null;
        Stack<Integer> queue = new Stack<>();

        while(current != null){
            queue.add(current.val);
            current = current.next;
        }

        ListNode newHead = new ListNode();
        ListNode iter = newHead;
        while(!queue.isEmpty()){
            iter.val = queue.pop();
            if(queue.isEmpty()){
                break;
            }
            iter.next = new ListNode();
            iter = iter.next;
        }
        return newHead;
    }

    public ListNode reverse(ListNode node){

        if(node == null){
            return null;
        }

        if(node.next == null){
            return node;
        }

        ListNode newHead = reverse(node.next);

        node.next.next = node;
        node.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        Main.println(reverseList(n1));
    }

}
