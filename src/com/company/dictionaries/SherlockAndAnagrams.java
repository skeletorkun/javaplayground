package com.company.dictionaries;

import com.company.Main;

import java.util.*;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        List<String> res = new ArrayList<>();
        HashMap<String, Integer> uniqueSubs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                String substring = s.substring(i, j);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                String uniq = new String(chars);
                Main.println("adding " + substring);
                res.add(substring);
                Integer orDefault = uniqueSubs.getOrDefault(uniq, 0);
                uniqueSubs.put(uniq, orDefault + 1);
            }
        }

        Main.println("res " + res.size());
        Main.println("uniq " + uniqueSubs);
        return uniqueSubs.values().stream()
                .filter(v -> v > 1).map(v -> (v * (v-1)) / 2)
                .reduce(Integer::sum).orElse(0);
    }


    public static void main(String[] args) {
        Main.println(sherlockAndAnagrams("ifailuhkqq")); // 6 instead of 3
//        Main.println(sherlockAndAnagrams("abba")); // 8 instead of 4
//        Main.println(sherlockAndAnagrams("abcd")); // OK
//        Main.println(sherlockAndAnagrams("kkkk")); // 10 OK
//        Main.println(sherlockAndAnagrams("cdcd"));
    }

}
