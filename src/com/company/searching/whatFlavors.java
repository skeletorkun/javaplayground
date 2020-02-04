package com.company.searching;

import com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class whatFlavors {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < cost.length; i++){
            if(cost[i] <= money){
                map.put(cost[i], i + 1);
                list.add(cost[i]);
            }
        }

        for(int i = 0; i < list.size()/2; i++){
            for(int j = list.size() -1; j > i; j--){
                int cost1 = list.get(i);
                int cost2 = list.get(j);
                if(cost1 + cost2 == money){
                    System.out.println( map.get(cost1) + " " + map.get(cost2));
                }
            }
        }

    }

    public static void main(String[] args) {
        String s = "DDUUDDUDUUUDDDUUDDUDUUUD";
        int max = 1000000000;
        Main.println(max);
//        Main.println(whatFlavors(s.length(), s));

    }
}
