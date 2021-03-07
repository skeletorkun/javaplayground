package com.company.leetcode;

import java.util.*;

public class NumSquares {

    int minSteps = Integer.MAX_VALUE;

    List<Integer> squares = new ArrayList<>();

    public int numSquares(int n) {


        for (int i = 1; i * i <= n; i++) {
            squares.add(i);
        }

        Collections.reverse(squares);
        println("Squares " + squares);

        recursiveSum(n, 0);

        return minSteps;

    }

    public void recursiveSum(int n, int stepsSoFar) {

        println(" called for " + n + " stepsSoFar " + stepsSoFar);
        if (minSteps < stepsSoFar) {
            return; // no need to continue
        }

        if (n == 0) {
            minSteps = stepsSoFar;
            return;
        }

        if (n < 0) {
            return;
        }

        for (Integer i : squares) {
            recursiveSum(n - (i * i), stepsSoFar + 1);
        }
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        NumSquares solution = new NumSquares();
        println(solution.numSquares(12));
    }
}
