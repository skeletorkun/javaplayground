package com.company.leetcode;

import com.company.Main;

import java.util.*;

public class findKthLargest {

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums){
            heap.add(i);
        }



        for (int i = 0; i < k - 1; i++) {

            Main.println(heap.poll());
        }

        return heap.poll();

    }

    public static void main(String[] args) {

        findKthLargest instance = new findKthLargest();

        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        Main.println("res " + instance.findKthLargest(ints, 4));
    }

}
