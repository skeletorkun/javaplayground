package com.company.yilu;

import com.company.Main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class question3 {


    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        List<List<Integer>> listOfLists = Arrays.asList(list1, list2);

        Integer reduceResult = list1.stream().reduce((x, y) -> x + y).get(); // will return the sum : 55
        Main.println(reduceResult);
        List<Integer> mapResult = list1.stream().map(x -> x * 10).collect(Collectors.toList()); // list1 = list2
        Main.println(mapResult);

        List<Integer> flatMapResult = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        Main.println(flatMapResult);

        String refused = "REFUSED";
        if(true && ! "REFUSED".equals(refused)){
            Main.println(refused);

        }

    }

}
