package com.company.arrays;

import com.company.Main;

import java.util.Arrays;

public class ActivityNotifications {
    // Complete the maxPrefix function below.
    static int activityNotifications(int[] expenditure, int d) {

        int total = 0;
        double median = 0d;
        for (int i = d; i < expenditure.length; i++) {
            int[] sub = Arrays.copyOfRange(expenditure, i - d, i);

            if (expenditure[i] >= 2 * median) {
                total++;
            }
        }

        return total;
    }

    private static double getMedian(int[] expenditure) {

        Arrays.sort(expenditure);
        int mid = expenditure.length / 2;
        if (expenditure.length % 2 == 0) {
            return (expenditure[mid] + expenditure[mid - 1]) / 2d;
        }

        return expenditure[mid];
    }

    public static void main(String[] args) {

//        int[] arr = new int[]{10, 20, 30, 40, 50};
//        int d = 3;

//        int[] arr = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
//        int d = 5;

        int[] arr = new int[]{1, 2, 3, 4, 4};
        int d = 4;

        int total = activityNotifications(arr, d);

        Main.println(total);

    }

}
