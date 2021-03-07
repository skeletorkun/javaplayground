package com.company.geeksforgeeks;

import com.company.Main;

import java.util.*;

public class arrays1 {


    // Function to find equilibrium point in the array.
    // a: input array
    // n: size of array
    static int equilibriumPoint(long a[], int n) {

        if (a.length == 1) {
            return 1;
        }

        long sum = Arrays.stream(a).sum();

        long sumSoFar = 0;
        for (int i = 0; i < a.length; i++) {

            if (sumSoFar == sum - sumSoFar - a[i]) {
                return i + 1;
            }
            sumSoFar += a[i];
        }
        return -1;
    }

    static ArrayList<Integer> leaders(int arr[], int n) {

        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {

            int current = arr[i];
            if (current >= max) {
                res.add(current);
                max = current;
            }
        }

        Collections.reverse(res);
        return res;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int begin = 0;
        for (int j = 0, arrLength = arr.length; j < arrLength; j++) {
            int i = arr[j];
            sum += i;
            queue.add(i);

            while (sum > s && queue.size() > 0) {
                sum -= queue.remove();
                begin++;
            }

            if (sum == s) {
                return new ArrayList<>(Arrays.asList(begin + 1, j + 1));
            }
        }

        return new ArrayList<>(Arrays.asList(-1, -1));

    }

    public static void sort012(int a[], int n) {


        int low = 0;
        int mid = 0;
        int high = a.length - 1;

        while (high > mid) {
            if (a[mid] == 0) {
                swap(a, mid, low);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                swap(a, mid, high);
                high--;
            }
        }
        Main.println(Arrays.asList(a));
    }

    /**
     * Swaps two elements
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void rotateArr(int arr[], int d, int n) {

        int i = 0;
        int t =  arr.length - n;

        int flyer = arr[i];
        do {

            int temp = arr[t];

            arr[t] = flyer;

            flyer = temp;

            i = t;

            // change target
            t -= n;
            if (t < 0) t += arr.length;


        } while (i != 0); // quit when we're back to start


        Main.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        rotateArr(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 5, 3);
//        rotateArr(new int[]{1, 2, 3, 4, 5}, 5, 2);
//        rotateArr(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 5, 3);
        rotateArr(new int[]{40, 13, 27, 87, 95, 40, 96, 71, 35, 79, 68, 2, 98, 3, 18, 93, 53, 57, 2, 81, 87, 42, 66, 90, 45, 20, 41, 30, 32, 18, 98, 72, 82, 76, 10, 28, 68, 57, 98, 54, 87, 66, 7, 84, 20, 25, 29, 72, 33, 30, 4, 20, 71, 69, 9, 16, 41, 50, 97, 24, 19, 46, 47, 52, 22, 56, 80, 89, 65, 29, 42, 51, 94, 1, 35, 65, 25}, 5, 69);
    }

}
