package com.company.leetcode;

import com.company.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PartitionLabels {

    public static int[] partitionLabels(String str) {

        // sample : ababcbacadefegdehijhklij
        char[] chars = str.toCharArray();

        ArrayList<Integer> res = new ArrayList<>();

        int currentMax = 0;
        int partitionLen = 0;
        for (int i = 0; i < chars.length; i++) {
            partitionLen++;
            char currentChar = chars[i];
            int lastIndexOfCurrentChar = str.lastIndexOf(currentChar);

            // this char in the partition appears later
            if(lastIndexOfCurrentChar > currentMax){
                currentMax = lastIndexOfCurrentChar;
            }

            // end of a partition
            if(currentMax == i){
                res.add(partitionLen); // add the current index to results
                currentMax = 0;        // reset counters
                partitionLen = 0;
            }
        }

        Main.println(res);
        return null;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        Main.println(Arrays.toString(partitionLabels(str)));
    }

}
