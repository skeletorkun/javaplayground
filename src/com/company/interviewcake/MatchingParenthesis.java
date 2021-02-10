package com.company.interviewcake;


import com.company.Main;

public class MatchingParenthesis {


    private static int matchingParenthesis(String str, int i) throws Exception {

        char[] chars = str.toCharArray();
        int counter = 0;

        if(chars[i] != '('){
            throw new Exception("invalid input");
        }

        for (int j = i; j < chars.length; j++) {

            char c = chars[j];
            if('(' == c){
                counter++;
            }else if(')' == c){
                counter--;
            }

            if(counter == 0){
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        try {
            Main.println(matchingParenthesis("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.", 10));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}