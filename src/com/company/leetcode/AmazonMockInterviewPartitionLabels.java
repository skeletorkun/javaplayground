package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AmazonMockInterviewPartitionLabels {

    public List<Integer> partitionLabels(String S) {

        List<Integer> partitions = new ArrayList<>();
        int currentMax = 0;
        int partitionLength = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            currentMax = Math.max(currentMax, S.lastIndexOf(chars[i]));
            partitionLength++;
            if(currentMax == i){
                partitions.add(partitionLength);
                partitionLength = 0;
            }
        }

        return partitions;

    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        AmazonMockInterviewPartitionLabels solution = new AmazonMockInterviewPartitionLabels();
//        println(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        println(solution.partitionLabels("ababcbacadefegdehijhklij"));

    }
}
