package com.company.leetcode;

import com.company.Main;

public class LinkedListCyclePos {

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     */

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

    public ListNode detectCycle(ListNode head) {

        int pos = 0;
        if(head == null || head.next == null){
            return null;
        }

        ListNode iter2 = head;
        while(head != null && iter2 != null && iter2.next != null){

            println("iter  " + head.val);
            println("iter2 " + iter2.val);
            head = head.next;
            pos++;
            iter2 = iter2.next.next;
            if(head == iter2){
                return head;
            }
        }

        return null;
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

        LinkedListCyclePos i = new LinkedListCyclePos();
        Main.println(i.detectCycle(n1));
    }

}
