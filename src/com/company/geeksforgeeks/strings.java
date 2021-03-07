package com.company.geeksforgeeks;

import com.company.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class strings {


    /**
     * Reverses the words in a given string
     * @param S
     * @return
     */
    static String reverseWords(String S) {

        List<String> words = Arrays.asList(S.split("\\."));
        Collections.reverse(words);
        return String.join(".", words);
    }

    public static void main(String[] args) {
        Main.println(reverseWords( "i.like.this.program.very.much"));

    }

}
