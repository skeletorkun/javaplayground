package com.company;

public class Solution {

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        println("res " + solution.doStuff());
    }

    private String doStuff() {
        return null;
    }
}
