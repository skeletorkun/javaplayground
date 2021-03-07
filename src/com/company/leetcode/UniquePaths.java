package com.company.leetcode;

import com.company.Main;

public class UniquePaths {


    public int uniquePaths(int m, int n) {

        int[][] cache = new int[m][n];

        walk(cache, m - 1, n - 1);

        return cache[m - 1][n - 1];
    }

    private int walk(int[][] cache, int m, int n) {

        if (cache[m][n] != 0) {
            return cache[m][n];
        }

        if (m == 0 && n == 0) {
            return 0;
        }

        int newM = Math.max(0, m - 1);
        if(m > 0){
            cache[newM][n] = walk(cache, newM, n);
        }

        int newN = Math.max(0, n - 1);
        if(n > 0){
            cache[m][newN] = walk(cache, m, newN);
        }

        return cache[newM][n] + cache[m][newN];
    }


    public static void main(String[] args) {

        UniquePaths instance = new UniquePaths();

        Main.println("res " + instance.uniquePaths(3, 4));
    }

}
