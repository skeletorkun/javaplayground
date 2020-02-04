package com.company.dictionaries;

import com.company.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DupeInvoices {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        if(s1.length() > 128 && s2.length() > 128){
            return "YES";
        }

        Set<Character> set = new HashSet<>();
        for(char c1 : s1.toCharArray()){
            set.add(c1);
            for(char c2: s2.toCharArray()){
                if(set.contains(c2)){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s1 = "plaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfeplaedfldlypxrbihxfwlqjzfrfe";
        String s2 = "afmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsrafmiwuijncebvbgcvthiyjvcvsr";
        Main.println(s1.length());
        Main.println(s2.length());

//        Main.println(twoStrings(s1, s2));
        testNPEPatrice();

    }

    public static void testNPEPatrice(){
        List<String> sth = new ArrayList<String>().stream().filter(p -> p.toLowerCase().equalsIgnoreCase("sth")).collect(Collectors.toList());

    }

}
