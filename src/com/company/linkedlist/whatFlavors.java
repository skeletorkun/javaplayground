package com.company.linkedlist;

import com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class whatFlavors {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Set<Integer> datas = new HashSet<>();
        Node n = head;
        while(n != null){
            if(datas.contains(n.data)){
                return true;
            }
            datas.add(n.data);
            n = n.next;
        }

        return false;

    }

    public static void main(String[] args) {
        String s = "DDUUDDUDUUUDDDUUDDUDUUUD";
        int max = 1000000000;
        Main.println(max);
//        Main.println(whatFlavors(s.length(), s));

    }
}
