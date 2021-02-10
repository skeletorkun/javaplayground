package com.company.booking;

import com.company.Main;

import java.util.*;

public class bookingDataStructure4 {


    public static int segment(int x, List<Integer> space) {

        int i = 0;
        List<Integer> subarray = space.subList(i, i + x);
        List<Integer> minimas = new ArrayList<>();

        int next;
        if(x == space.size()){
            return Collections.min(space);
        }
        while (i + x < space.size()) {
            minimas.add(Collections.min(subarray));
            next = i + x;
            subarray.set((next - 1) % x, space.get(next));
            i++;
        }

        return Collections.max(minimas);
    }

    public static void main(String[] args) {

        List<Integer> space = Arrays.asList(8, 2, 4, 12, 3);
        Main.println("Result is " + segment(5, space));
    }

}
