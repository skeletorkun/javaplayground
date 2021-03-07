package com.company.codebyte;

import com.company.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringWildCard {

    static Set<String> allCombos = new HashSet<>();

    public static void generate(String s) {
        allCombos.clear();

        recurse(s);

        Main.println(allCombos);
    }

    private static void recurse(String s) {

        if(!s.contains("?")){
            allCombos.add(s);
            return;
        }

        recurse(s.replaceFirst("\\?", "1"));
        recurse(s.replaceFirst("\\?", "0"));
    }


    public static void main(String[] args) {

        generate("10??");

    }

}
