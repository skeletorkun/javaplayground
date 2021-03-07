package com.company.leetcode;

import com.company.Main;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            List<String> group = anagrams.getOrDefault(String.valueOf(chars), new ArrayList<>());
            group.add(s);
            anagrams.put(String.valueOf(chars), group);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        Main.println(groupAnagrams(strs));
    }

}
