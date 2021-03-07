package com.company.basics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeAnagram {

    static int makeAnagram(String a, String b) {

        char[] charsA = a.toCharArray();

        List<Character> aChars = a.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        List<Character> bChars = b.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        int count = 0;
        for (char c : charsA) {

            Character character = c;
            aChars.remove(character);

            if(bChars.contains(character)){
                bChars.remove(character);
            }
            else{
                count++;
            }
        }

        return count + bChars.size();
    }
    public static void main(String[] args) {

        com.company.Main.println(makeAnagram("cde", "abc"));
    }
}