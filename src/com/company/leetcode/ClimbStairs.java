package com.company.leetcode;

import com.company.Main;

public class ClimbStairs {

    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return climb(n, n, cache);
    }

    public int climb(int n, int stairsRemaining, int[] cache){
        if(stairsRemaining < 0) return 0;
        if(stairsRemaining == 1) return 1;
        if(stairsRemaining == 2) return 2;

        if(cache[stairsRemaining] != 0) return cache[stairsRemaining];

        cache[stairsRemaining] = climb(n, stairsRemaining - 1, cache) + climb(n, stairsRemaining - 2, cache);
        return cache[stairsRemaining];
    }

    public static void main(String[] args) {

        Long.parseLong("4.5");
        ClimbStairs instance = new ClimbStairs();
        Main.println(instance.climbStairs(44));
    }

}
