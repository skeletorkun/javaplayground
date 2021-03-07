package com.company.leetcode;

import com.company.Main;

import java.util.HashMap;
import java.util.Map;

public class LinkedListRotate {

    /**
     * Given the head of a linked list, rotate the list to the right by k places.
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


    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;
        if(k == 0) return head;

        ListNode newHead = head;
        int headVal = head.val;
        for (int i = 1; i < k + 1; i++) {
             newHead = rotateOnce(newHead);
             println(i + " Val " + newHead.val);
             if(newHead.val == headVal){ // cycle competed
                 k = i + k % i ;
                 println("Cycle completed " + i);

             }

        }

        return newHead;
    }

    private ListNode rotateOnce(ListNode head) {

        if(head.next == null){
            return head;
        }

        ListNode iter = head;
        ListNode prev = null;
        while(iter.next != null){
            prev = iter;
            iter = iter.next;
        }

        prev.next = null;
        iter.next = head;
        return iter;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        // 3,2,0,-4
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

        LinkedListRotate i = new LinkedListRotate();
        Main.println(i.rotateRight(n1, 6));
    }

}
