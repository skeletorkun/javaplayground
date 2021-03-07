package com.company.amazon;

public class MinimumOperations {


    public static void main(String[] args) {

        int target = 5;
        int countOperations = 1;
        int currentNum = 1;
        while (currentNum != target) {
            if (currentNum * 2 > target) {
                currentNum++;
            } else {
                currentNum *= 2;
            }
            countOperations++;
            System.out.println(currentNum);
        }

        System.out.println(countOperations);

    }
}
