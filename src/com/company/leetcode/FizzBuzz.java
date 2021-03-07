package com.company.leetcode;

import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            StringBuilder s = new StringBuilder();
            if (i % 3 == 0) {
                s.append("Fizz");
            }

            if (i % 5 == 0) {
                s.append("Buzz");
            }

            if (s.length() == 0) {
                s.append(i);
            }

            res.add(s.toString());

        }

        return res;
    }

    public static void main(String[] args) {

        FizzBuzz instance = new FizzBuzz();
        Main.println(instance.fizzBuzz(15));
    }

}
