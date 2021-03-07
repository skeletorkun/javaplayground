package com.company.leetcode;

import java.util.*;

public class AmazonMockInterviewIntegerRankArray {

    class Num{
        Integer val;
    }

    public int[] arrayRankTransform(int[] arr) {

        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indexes = map.getOrDefault(arr[i], new ArrayList<>());
            indexes.add(i);
            map.put(arr[i], indexes);
        }

        println(map);
        int[] res = new int[arr.length];

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {

            for (Integer index : e.getValue()){
                res[index] = e.getKey();
            }
        }

        return res;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        AmazonMockInterviewIntegerRankArray solution = new AmazonMockInterviewIntegerRankArray();
        println(Arrays.toString(solution.arrayRankTransform(new int[]{40,10,20,30, 40})));
    }
}
