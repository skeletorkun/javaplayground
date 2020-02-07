package com.company.sixnomads;


import java.util.*;
import java.util.stream.Collectors;

import static com.company.Main.println;

public class question2 {
    // Complete the droppedRequests function below.
    static int droppedRequests(List<Integer> requestTime) {

        int droppedMessages = 0;

        Map<Integer, Integer> freqMap = requestTime.stream().
                collect(Collectors.toMap(
                        w -> w, w -> 1, Integer::sum));

        List<Integer> seconds = new ArrayList<>(freqMap.keySet());

        int totalIn3Seconds = 0;
        int totalIn10Seconds = 0;
        int totalIn60Seconds = 0;

        int prevSecond = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {

            Integer currentSecond = e.getKey();
            if(currentSecond != prevSecond){
                // second changed

                if(currentSecond > prevSecond + 2){
                    totalIn3Seconds = 0;
                }

                prevSecond = currentSecond;

                totalIn3Seconds += e.getValue();


            }

        }

        return droppedMessages;
    }

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7);
//        List<Integer> list = Arrays.asList(1, 1, 1, 1, 2);

//        List<Integer> list = Arrays.asList(
//                1, 1, 1,
//                2, 2, 2,
//                3, 3, 3,
////                4, 4, 4,
//                5, 5, 5,
//                6, 6, 6,
//                7, 7, 7,
//                8, 8, 8);

        List<Integer> list = Arrays.asList(1, 6, 7, 8, 9, 10, 11, 12, 14, 52, 66);

        println(droppedRequests(list));
    }
}