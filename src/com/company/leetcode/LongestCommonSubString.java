package com.company.leetcode;

import com.company.Main;

import java.util.Arrays;

public class LongestCommonSubString {

    public static void main(String[] args) {

        LongestCommonSubString instance = new LongestCommonSubString();

//        int[] A = new int[]{1,2,3,2,1};
//        int[] B = new int[]{3,2,1,4,7};


        int[] A = new int[]{70,39,25,40,7};
        int[] B = new int[]{52,20,67,5,31};

        println(instance.findLength(A, B));

    }

    private int findLength(int[] A, int[] B) {

        String a = getString(A);
        String b = getString(B);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= a.length(); i++) {

            for (int j = 0; j < i; j++) {
                if (b.contains(a.substring(j, i))){
                    println(a.substring(j, i));
                    max = Math.max(max, i - j);
                }
            }
        }

        return max;
    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }


    private String getString(int[] A) {
        return Arrays.toString(A)
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .replace(",", "");
    }

}
