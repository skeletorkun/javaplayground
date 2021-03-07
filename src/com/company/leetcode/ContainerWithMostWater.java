package com.company.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;

public class ContainerWithMostWater {

    static class Tuple {
        Integer i;
        Integer j;
        Integer area;

        public Tuple(Integer i, Integer j, Integer profit) {
            this.i = i;
            this.j = j;
            this.area = profit;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Tuple.class.getSimpleName() + "[", "]")
                    .add("i=" + i)
                    .add("j=" + j)
                    .add("area=" + area)
                    .toString();
        }
    }

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;
        Queue<Tuple> tuples = new PriorityQueue<>(Comparator.comparing(o -> o.area));
        for (int i = 0; i < height.length; i++) {

            for (int j = 0; j < height.length; j++) {

                int a = Math.min(height[i], height[j]);
                int b = j - i;
//                Tuple tuple = new Tuple(i, j, a * b);
//                tuples.add(tuple);

                maxArea = Math.max(maxArea, a * b);
            }
        }
        println(maxArea);
        return maxArea;
    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        ContainerWithMostWater solution = new ContainerWithMostWater();


        int[] nums = {2, 3, 4, 5, 18, 17, 6};
//        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] nums = {1,1000,1000,6,2,5,4,8,3,7};
        solution.maxArea(nums);
    }
}
