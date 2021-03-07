package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class MaxProfit {

    static class Tuple{
        int buy;
        int sell;
        int profit;

        public Tuple(int buy, int sell, int profit) {
            this.buy = buy;
            this.sell = sell;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Tuple.class.getSimpleName() + "[", "]")
                    .add("buy=" + buy)
                    .add("sell=" + sell)
                    .add("profit=" + profit)
                    .toString();
        }
    }
    private static String maxProfit(int[] nums) {

        println(Arrays.toString(nums));

        int currentMin = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;
        int currentMaxIndex = -1;
        int currentMinIndex = -1;

        List<Tuple> candidates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            if(current > currentMax){
                println("max changed " + current);
                currentMax = current;
                currentMaxIndex = i;
            }

            if(current < currentMin){
                println("min changed " + current + " reset streak");

                if(currentMaxIndex != -1 && currentMinIndex != -1 && currentMax > currentMin){
                    Tuple tuple = new Tuple(currentMinIndex, currentMaxIndex, currentMax - currentMin);
                    println("candidate " + tuple.toString());
                    candidates.add(tuple);
                }

                currentMin = current;
                currentMax = Integer.MIN_VALUE;
                currentMinIndex = i;
            }
        }

        if(currentMaxIndex != -1 && currentMinIndex != -1 && currentMax > currentMin){
            Tuple tuple = new Tuple(currentMinIndex, currentMaxIndex, currentMax - currentMin);
            println("candidate " + tuple.toString());
            candidates.add(tuple);
        }

        return null;
    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        int[] nums = {70, 10, 50, 30, 60, 40};
        println(maxProfit(nums));
    }
}
