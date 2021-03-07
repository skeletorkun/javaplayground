package com.company.leetcode;

import com.company.Main;

import java.util.List;
import java.util.Stack;

public class LinkedListCycle {

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

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        ListNode iter2 = head;
        while(head != null && iter2 != null && iter2.next != null){

            println("iter  " + head.val);
            println("iter2 " + iter2.val);
            head = head.next;
            iter2 = iter2.next.next;
            if(head == iter2){
                return true;
            }
        }

        return false;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        // 3,2,0,-4
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        LinkedListCycle i = new LinkedListCycle();
        Main.println(i.hasCycle(n1));
    }

}
