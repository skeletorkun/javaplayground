package com.company.leetcode;

import com.company.Main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class AddTwoNumbersII {

    static class ListNode {
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
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long n1 = listToNum(l1);
        System.out.println("n1 " + n1);

        long n2 = listToNum(l2);
        System.out.println("n2 " + n2);

        return numToList(n1 + n2);
    }

    private ListNode numToList(long num) {
        System.out.println("sum " + num);

        Deque<Integer> deque = new ArrayDeque<>();

        String.valueOf(num).chars().forEach(c -> deque.offer(Integer.parseInt(String.valueOf((char)c))));

        ListNode ln = new ListNode(deque.pop());
        while(!deque.isEmpty()){
            ListNode temp = ln;
            ln = new ListNode(deque.pop());
            ln.next = temp;
        }
        return ln;
    }

    private long listToNum(ListNode l) {

        StringBuilder sb = new StringBuilder();
        while(l != null){
            sb.insert(0, l.val);
            l = l.next;
        }
        return Long.parseLong(sb.toString());
    }


    public static void main(String[] args) {

        AddTwoNumbersII solution = new AddTwoNumbersII();

        //[3,9,9,9,9, 9,9,9,9,9]
        //[7]
        List<Integer> nums1 = Arrays.asList(9,9,9,9,9,9,9);
        List<Integer> nums2 = Arrays.asList(9,9,9,9);  // expect 8,9,9,9,0,0,0,1
        ListNode l1 = arrayToLinkedList(nums1);
        ListNode l2 = arrayToLinkedList(nums2);
        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.println("res " +solution.listToNum(res));

//        nums1 = Arrays.asList(2,4,9);
//        nums2 = Arrays.asList(5,6,4,9);  // expect [7,0,4,0,1]
//        l1 = arrayToLinkedList(nums1);
//        l2 = arrayToLinkedList(nums2);
//        res = solution.addTwoNumbers(l1, l2);
//        System.out.println("res " + solution.listToNum(res));
//
//        nums1 = Arrays.asList(2,4,3);
//        nums2 = Arrays.asList(5,6,4);  // expect [7,0,8]
//        l1 = arrayToLinkedList(nums1);
//        l2 = arrayToLinkedList(nums2);
//        res = solution.addTwoNumbers(l1, l2);
//        System.out.println("res " + solution.listToNum(res));

        /**
         * [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
         * [5,6,4]
         */

        nums1 = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1);
        nums2 = Arrays.asList(5,6,4);  // expect [7,0,8]
        l1 = arrayToLinkedList(nums1);
        l2 = arrayToLinkedList(nums2);
        res = solution.addTwoNumbers(l1, l2);
        System.out.println("res " + solution.listToNum(res));
    }

    /**
     * Converts [3,9,9,9,9, 9,9,9,9,9] to a LinkedList
     * @param nums
     * @return
     */
    private static ListNode arrayToLinkedList(List<Integer> nums) {

        ListNode head = new ListNode(nums.get(0));
        ListNode iter = head;

        for (int i = 1; i < nums.size(); i++) {
            iter.next = new ListNode(nums.get(i));
            iter = iter.next;
        }

        return head;
    }

}
