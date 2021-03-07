package com.company.leetcode;

import com.company.Main;

import java.util.*;

public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {


        return "dbaacbabababababeeb";
    }


    boolean isPalindrome(String s){
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }


    public static void main(String[] args) {

        LongestPalindromeSubstring instance = new LongestPalindromeSubstring();


        Main.println(instance.longestPalindrome("babad"));
    }

}
