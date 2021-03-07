package com.company.codebyte;

import com.company.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSumProblem {

    public static void generatePowerSets(int[] arr) {


        List<List<Integer>> powerSets = new ArrayList<>();
        powerSets.add(new ArrayList<>());

        // []
        // [], [1]
        // [], [1], [2], [1, 2]
        // [], [1], [2], [1, 2], [3] ...
        for (int i : arr){

            ArrayList<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> subset : powerSets){
                ArrayList<Integer> temp = new ArrayList<>(subset);
                temp.add(i);
                newSubSets.add(temp);
            }

            powerSets.addAll(newSubSets);
        }

        Main.println(powerSets);
    }


    public static void main(String[] args) {

        generatePowerSets(new int[]{1, 2, 3});

    }

}
