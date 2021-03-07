package com.company.codebyte;

import com.company.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Steps {

    static Set<ArrayList<Integer>> allCombos = new HashSet<>();

    public static void generate(int steps) {
        allCombos.clear();

        recurse(new ArrayList<Integer>(), steps);

        Main.println(allCombos);
    }

    private static void recurse(ArrayList<Integer> combo, int steps) {

        if (steps == 0) {
            allCombos.add(combo);
            return;
        }

        if (steps > 0) {
            ArrayList<Integer> temp1 = new ArrayList<>(combo);
            temp1.add(1);
            recurse(temp1, steps - 1);
        }

        if (steps > 1) {
            ArrayList<Integer> temp2 = new ArrayList<>(combo);
            temp2.add(2);
            recurse(temp2, steps - 2);
        }

    }


    public static void main(String[] args) {

        generate(4);

    }

}
