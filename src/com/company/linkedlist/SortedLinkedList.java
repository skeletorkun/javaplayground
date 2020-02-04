package com.company.linkedlist;

import com.company.Main;

public class SortedLinkedList {


    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if(head == null) return newNode;

        DoublyLinkedListNode node = head;
        while (node != null) {

            if (node.data < data) {


                if(node.next == null){
                    //add to end
                    newNode.prev = node;
                    node.next = newNode;
                    return head;

                }
                else{
                    node = node.next;
                }
            } else {
                newNode.prev = node.prev;
                newNode.next = node;
                if(node.prev != null){
                    node.prev.next = newNode;
                }
                else{
                    head = newNode;
                }

                return head;
            }

        }

        return head;
    }


    public static void main(String[] args) {
        String s = "DDUUDDUDUUUDDDUUDDUDUUUD";
        int max = 1000000000;
        Main.println(max);
//        Main.println(whatFlavors(s.length(), s));

    }
}
