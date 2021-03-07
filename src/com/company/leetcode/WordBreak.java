package com.company.leetcode;

import com.company.Main;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    Map<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<Character> chars = new HashSet<>();

        wordDict.forEach(w -> chars.addAll(w.chars().mapToObj(c -> (char)c).collect(Collectors.toSet())));
        Set<Character> sChars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        if(!chars.containsAll(sChars)){
            return false;
        }

        return recursiveCheck(s, wordDict);
    }

    private boolean recursiveCheck(String s, List<String> wordDict) {
        if(cache.containsKey(s)){
            println("cache hit " + s);
            return cache.get(s);
        }

        if(wordDict.contains(s)){
            cache.put(s, true);
            return true;
        }

        for (int i = 0; i < s.length(); i++) {

            String prefix = s.substring(0, i);
            String remaining = s.substring(i);
            println("doing " + prefix + " " + remaining);
            if(recursiveCheck(prefix, wordDict) && recursiveCheck(remaining, wordDict)){
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);
        return false;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        WordBreak instance = new WordBreak();

        Main.println(instance.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

}
