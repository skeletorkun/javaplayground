package com.company.codebyte;

import com.company.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstReverse {

    public static String FirstReverse(String str) {

        String[] split = str.split(" ");

        List<String> res = new ArrayList<>();
        for (String s : split){
            res.add(0, new StringBuilder(s).reverse().toString());
        }

        return res.stream().collect(Collectors.joining(" "));
    }


    public static void main(String[] args) {
        Main.println(FirstReverse("I love code"));
    }

}
