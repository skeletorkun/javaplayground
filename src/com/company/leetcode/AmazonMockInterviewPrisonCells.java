package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AmazonMockInterviewPrisonCells {


    Map<String, int[]> cache = new HashMap<>();
    Map<String, Integer> dayCacheByPrint = new HashMap<>();
    Map<Integer, int[]> dayCache = new HashMap<>();

    public int[] prisonAfterNDays(int[] cells, int n) {

        for (int i = 0; i < n; i++) {
            String print = Arrays.toString(cells).replace(" ", "");
            println(i + " -> " +  print);
            if (cache.containsKey(print)) {
                println("seenBefore on day " + dayCacheByPrint.get(print) + " today is " + i);
                int cycle = dayCacheByPrint.get(print);

                int returning = n % (i - cycle) - 1;

                if(i - cycle == 1){
                    returning = 1;
                }
                if(cycle == 0){
                    returning = 0;
                }
                if(returning == -1){
                    returning = i - cycle - 1;
                }
                println("n " + n + " i " + i + " cycle " + cycle + " returning " + returning);
                return dayCache.get(returning);

            } else {
                cells = getTomorrow(cells);
//                println("this is new " + i);
                cache.put(print, cells);
                dayCacheByPrint.put(print, i);
                dayCache.put(i, cells);
            }
        }
        println("no cache ");
        return cells;
    }

    int[] getTomorrow(int[] nums) {
        int[] tomorrow = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || i == nums.length - 1) {
                tomorrow[i] = 0;
            } else {
                tomorrow[i] = getTomorrow(nums[i - 1], nums[i + 1]);
            }
        }

        return tomorrow;
    }

    int getTomorrow(int right, int left) {

        if ((right == 1 && left == 1) || (right == 0 && left == 0)) {
            return 1;
        }

        return 0;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        AmazonMockInterviewPrisonCells solution = new AmazonMockInterviewPrisonCells();
        int[] res = new int[]{0, 1, 0, 1, 1, 0, 0, 1};

//        res = solution.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
//        println("exp [0, 0, 1, 1, 0, 0, 0, 0]");
//        println("res " + Arrays.toString(res));
//        println("------");
//
//        res = solution.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
//        println("exp [0, 0, 1, 1, 1, 1, 1, 0]");
//        println("res " + Arrays.toString(res));
//        println("------");
//
//        res = solution.prisonAfterNDays(new int[]{1,1,0,1,1,0,1,1}, 6);
//        println("exp [0, 0, 1, 0, 0, 1, 0, 0]");
//        println("res " + Arrays.toString(res));
//        println("------");


//        res = solution.prisonAfterNDays(new int[]{1,1,0,1,1,0,0,1}, 300663720);
//        println("exp [0,0,1,0,0,1,1,0]");
//        println("res " + Arrays.toString(res).replace(" ", ""));

        res = solution.prisonAfterNDays(new int[]{0,0,1,0,0,1,0,0}, 44640906);
        println("exp [0,0,1,0,0,1,0,0]");
        println("res " + Arrays.toString(res).replace(" ", ""));

    }
}
