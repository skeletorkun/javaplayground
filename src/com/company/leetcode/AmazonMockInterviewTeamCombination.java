package com.company.leetcode;

import java.util.Arrays;

public class AmazonMockInterviewTeamCombination {

    int[][] cache = null;

    public int numTeams(int[] rating) {

        cache = new int[rating.length][rating.length];
        Arrays.stream(cache).forEach(a -> Arrays.fill(a, -1));

        int count = 0;
        for (int i = 0; i < rating.length - 2; i++) {

            for (int j = i + 1; j < rating.length - 1; j++) {
                boolean smaller = rating[i] < rating[j];
                count += getCount(rating, i, j, smaller);
            }
        }

        return count;

    }

    private int getCount(int[] rating, int i, int j, boolean smaller) {

        if (smaller && cache[j][1] != -1) {
            println("cache hit");
            return cache[j][1];
        } else if (cache[j][0] != -1) {
            println("cache hit");
            return cache[j][0];
        }

        int countSmaller = 0;
        int countBigger = 0;
        for (int k = j + 1; k < rating.length; k++) {
            if (smaller && rating[j] < rating[k]) {
                println(Arrays.asList(rating[i], rating[j], rating[k]));
                countSmaller++;
            } else if (!smaller && rating[j] > rating[k]) {
                println(Arrays.asList(rating[i], rating[j], rating[k]));
                countBigger++;
            }
        }
        if (smaller) {
            cache[j][1] = countSmaller;
        } else {
            cache[j][0] = countBigger;
        }
        return smaller ? countSmaller : countBigger;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {
        AmazonMockInterviewTeamCombination parkingSystem = new AmazonMockInterviewTeamCombination();
//        println("res " + parkingSystem.numTeams(new int[]{2,5,3,4,1}));
//        println("res " + parkingSystem.numTeams(new int[]{6, 3, 7, 9, 5, 1, 2, 8}));
        println("res " + parkingSystem.numTeams(new int[]{5, 2, 8, 6, 10, 9, 4, 1, 3}));
    }
}
