package com.company.sort;

import com.company.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MarkAndToys {


    static int maximumToys(int[] prices, int k) {

        List<Integer> list = Arrays.stream(prices).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int total = 0;
        int i = 0;
        while(total < k){
            total += list.get(i);
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String note = "give one grand today";

    }

}
