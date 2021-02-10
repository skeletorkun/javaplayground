package com.company.basics;


import java.util.Locale;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        char[] aChars = a.toLowerCase().toCharArray();
        char[] bChars = b.toLowerCase().toCharArray();
        java.util.Arrays.sort(aChars);
        java.util.Arrays.sort(bChars);
        return java.util.Arrays.equals(aChars, bChars);
    }


    public static void main(String[] args) {

        com.company.Main.println(isAnagram("Hello", "hello"));
        com.company.Main.println(isAnagram("managra", "anagram"));
    }
}