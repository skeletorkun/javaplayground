package com.company.interviewcake;


import com.company.Main;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PermutationPalindrome {


    /**
     * Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome. ↴
     * @param str
     * @return
     */
    private static boolean hasPermutationPalindrome(String str){

        long oddCharCount = createFreqMap(str).values().stream().filter(f -> f%2 != 0).count();

        return (oddCharCount == 1 || oddCharCount == 0);

    }

    private static Map<Character, Long> createFreqMap(String s){

        return s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {

        Main.println(hasPermutationPalindrome("civic"));
        Main.println(hasPermutationPalindrome("ivicc"));
        Main.println(hasPermutationPalindrome("civil"));
        Main.println(hasPermutationPalindrome("livci"));

    }
}