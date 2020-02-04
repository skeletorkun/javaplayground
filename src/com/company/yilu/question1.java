package com.company.yilu;

import com.company.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class question1 {

    /**
     * Finds and returns the first non repeated character in a given String.
     * Returns null if not found
     * @param str   input
     * @return
     */
    static Character findFirstNonRepeatedChar(String str) {
        for(char c : str.toCharArray()){
            if(str.indexOf(c) == str.lastIndexOf(c)){
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "plaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfe";
        String s2 = "afmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsr";
        String s3 = "afmiwuiafi";

        Main.println(findFirstNonRepeatedChar(s1));
        Main.println(findFirstNonRepeatedChar(s2));
        Main.println(findFirstNonRepeatedChar(s3));
    }

}
