package com.company.codebyte;

import com.company.Main;

import java.util.*;

public class MaxProfit {


    public static void maxProfit(List<Integer> markers) {

        int maxProfit = Integer.MIN_VALUE;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < markers.size() - 1; i++) {
            if(isGoingDown(markers, i)){
                continue;
            }
        }

    }

    private static boolean isGoingDown(List<Integer> markers, int i){
        return markers.get(i) < markers.get(i + 1);
    }



    public static void main(String[] args) {

        maxProfit(Arrays.asList(45, 24, 35, 31, 40, 38, 11));

    }

}
