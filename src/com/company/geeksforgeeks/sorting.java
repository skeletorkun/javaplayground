package com.company.geeksforgeeks;

import com.company.Main;

import java.util.Arrays;

public class sorting {

    // arr: input array
    // n: size of the array
    //Function to sort the array into a wave-like array.
    public static void convertToWave(int arr[], int n) {

        if (arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i += 2) {
            swap(arr, i, i + 1);
        }

        Main.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = temp;
    }



    public static void main(String[] args) {
//        Main.println(findIndexes(new long[]{1, 3, 5, 5, 5, 5, 7, 123, 125}, 5));

    }

}
