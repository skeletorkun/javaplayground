package com.company.basics;


import java.util.Arrays;

public class Add {

    public static void add(Integer... args){

        int sum = 0;
        for (Integer arg : args) {
            sum += arg;
        }

        System.out.println(sum);
    }


    public static void main(String[] args) {

        add(1, 2);
    }
}