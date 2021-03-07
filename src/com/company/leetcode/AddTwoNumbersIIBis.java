package com.company.leetcode;

import com.company.Main;

import java.util.Arrays;
import java.util.List;

public class AddTwoNumbersIIBis {

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

        boolean isNegative = num < 0;
        if (isNegative) {
            num *= -1;
        }

        char[] chars = String.valueOf(num).toCharArray();

        int headVal = Integer.parseInt(String.valueOf(chars[0]));
        headVal = isNegative ? headVal * -1 : headVal;

        ListNode head = new ListNode(headVal);
        ListNode iterator = head;

        System.out.println("chars " + Arrays.toString(chars));
        System.out.print(headVal);
        if (chars.length > 1) {
            for (int i = 1; i < chars.length; i++) {
                iterator.next = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
                System.out.print("  ->  " + Integer.parseInt(String.valueOf(chars[i])));
                iterator = iterator.next;
            }
        }

        System.out.println("\nhead " + head.val);

        return head;
    }

    private long listToNum(ListNode l) {

        int zeros = 0;

        ListNode iterator = l;
        while (iterator != null) {
            iterator = iterator.next;
            zeros++;
        }
        long sum = 0;
        iterator = l;
        while (iterator != null) {
            zeros--;
            // System.out.println("val " + iterator.val);
            //System.out.println("Math.pow(10, zeros) " + (long)Math.pow(10, zeros));
            sum += iterator.val * (long)Math.pow(10, zeros);
            System.out.println("sum " + sum);

            iterator = iterator.next;
        }

        return sum;
    }


    public static void main(String[] args) {

        AddTwoNumbersIIBis solution = new AddTwoNumbersIIBis();

        Main.println("pow test " + Math.pow(10, 3));
        //[3,9,9,9,9, 9,9,9,9,9]
        //[7]
        List<Integer> nums1 = Arrays.asList(7,2,3,4);
        List<Integer> nums2 = Arrays.asList(5,6,4);
        ListNode l1 = arrayToLinkedList(nums1);
        ListNode l2 = arrayToLinkedList(nums2);
        solution.addTwoNumbers(l1, l2);
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
