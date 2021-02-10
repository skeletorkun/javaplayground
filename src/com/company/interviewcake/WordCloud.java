package com.company.interviewcake;


import com.company.Main;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCloud {


    /**
     * Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome. ↴
     * @param str
     * @return
     */
    private static Map<String, Long> wordCloud(String str){

        return createFreqMapWords(str);

    }

    private static Map<String, Long> createFreqMapWords(String str){

        return Arrays.stream(str.split(" ")).map(s -> s.replace(",", "")
                .replace(".", "")
                .replace("(", "")
                .replace(")", "")
                .replace("-", "")
                .toLowerCase()).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {

        Main.println(wordCloud("After beating the eggs, Dana read the next step: Add milk and eggs, then add flour and sugar."));
        Main.println(wordCloud("We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.\n" +
                "The bill came to five dollars."));
    }
}