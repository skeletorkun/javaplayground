package com.company.codebyte;

import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    static List<String> allCombos = new ArrayList<>();

    public static void generate(int n) {
        allCombos.clear();

        String s = "(";
        recurse(s, n - 1, n);

        Main.println(allCombos);
    }

    private static void recurse(String s, int open, int closed) {

        if (open == 0 && closed == 0) {
            allCombos.add(s);
        }

        if (open > 0) recurse(s + "(", open - 1, closed);
        if (closed > open) recurse(s + ")", open, closed - 1);

    }


    public static void main(String[] args) {

        generate(3);

    }

}
