package com.company.amazon;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {


    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    int twoSums(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                return map.get(remaining);
            } else {
                map.put(remaining, i);
            }
        }

        return 1;

    }


    public static void main(String[] args) {

        TwoSums solution = new TwoSums();

        solution.twoSums(new int[]{2, 7, 11, 15}, 18);

    }
}
