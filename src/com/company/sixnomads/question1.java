package com.company.sixnomads;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.company.Main.println;

public class question1 {
    // Complete the droppedRequests function below.
    static int droppedRequests(List<Integer> requestTime) {

        int droppedMessages = 0;

        boolean quotaSecReached = false;
        boolean quota10SecReached = false;
        boolean quota60SecReached = false;

        Map<Integer, Integer> freqMap = requestTime.stream().
                collect(Collectors.toMap(
                        w -> w, w -> 1, Integer::sum));

        int messageCountThisSecond = 0;
        int messagesCountLast10Seconds = 0;
        int messagesCountLast60Seconds = 0;

        int prev = Integer.MIN_VALUE;
        int skippedIndexes = 0;
        for (int i = 0; i < requestTime.size(); i++) {

            // second changed
            Integer current = requestTime.get(i);
            if (prev != current) {
                skippedIndexes = current - prev;
                prev = current;


                messageCountThisSecond = 0;
                quotaSecReached = false;
                quota10SecReached = false;
                quota60SecReached = false;

                if (current > 9) {
                    for (int j = 0; j < skippedIndexes; j++) {
                        if (freqMap.containsKey(i - 10 - j)) {
                            messagesCountLast10Seconds = Math.max(messagesCountLast10Seconds - freqMap.get(i - 10 - j), 0);
                        }
                    }
                }

                if (current > 59) {
                    for (int j = 0; j < skippedIndexes; j++) {
                        if (freqMap.containsKey(i - 60 - j)) {
                            messagesCountLast60Seconds = Math.max(messagesCountLast60Seconds - freqMap.get(i - 60 - j), 0);
                        }
                    }

                }
            }

            messageCountThisSecond++;
            messagesCountLast10Seconds++;
            messagesCountLast60Seconds++;

            // check 1 second quota
            if (messageCountThisSecond > 3) {
                quotaSecReached = true;
            }
            if (messagesCountLast10Seconds > 20) {
                quota10SecReached = true;
            }
            if (messagesCountLast60Seconds > 60) {
                quota60SecReached = true;
            }
            if (quotaSecReached || quota10SecReached || quota60SecReached) {
                droppedMessages++;
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