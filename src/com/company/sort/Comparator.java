package com.company.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {


    class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    // complete this method
    public int compare(Player a, Player b) {
        int intCompare = Integer.compare(a.score, b.score);
        if(intCompare != 0){
            return intCompare;
        }
        else{
            return a.name.compareTo(b.name);
        }
    }

    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String note = "give one grand today";

    }

}
