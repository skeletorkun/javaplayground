package com.company.geeksforgeeks;

import com.company.Main;

import java.util.Arrays;

public class math1 {


    static int missingNumber(int array[], int n) {

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return n;
    }

    static int trailingZeroes(int N) {

        int fives = 0;
        for (int i = 5; N / i >= 1; i *= 5)
            fives += N / i;

        return fives;
    }

    public static String fractionToDecimal(int numerator, int denominator) {

        double d = numerator / (double) denominator;

        if(hasRepeatingDecimal(d)){
            // add parenthesis
        }

        String s = String.valueOf(d);
        return s;
    }

    private static boolean hasRepeatingDecimal(double d){

//        String.valueOf(d).indexOf("", 1)
        return false;
    }


    public static void main(String[] args) {
        Main.println(fractionToDecimal(1, 3));
        Main.println(fractionToDecimal(5, 2));
        Main.println(fractionToDecimal(10000000, 9));
    }

}
