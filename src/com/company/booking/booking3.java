package com.company.booking;

import com.company.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class booking3 {

    private static class Call {
        private long startedAt;
        private long finishedAt;
        private int count = 0;

        Call(final long startedAt, final long finishedAt) {
            this.startedAt = startedAt;
            this.finishedAt = finishedAt;
        }
    }


    private static boolean doesOverlap(final Call call1, final Call call2) {
        if (call1.startedAt >= call2.startedAt && call1.startedAt <= call2.finishedAt) {
            return true;
        }
        return call2.startedAt >= call1.startedAt && call2.startedAt <= call1.finishedAt;
    }

    private static int concurrentCount(final List<Call> calls) {

        for (int i = 0; i < calls.size(); i++) {

            for (int j = i + 1; j < calls.size(); j++) {
                if (doesOverlap(calls.get(i), calls.get(j))) {
                    calls.get(i).count++;
                    calls.get(j).count++;
                }
            }
        }
        int max = 0;
        for (Call call: calls) {
            max = Math.max(max, call.count);
        }
        return max;
    }

    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        final List<Call> calls = callsTimes.stream().map(list -> new Call(list.get(0), list.get(1))).collect(Collectors.toList());
        return concurrentCount(calls) - noOfCurrentAgents;
    }

    public static void main(String[] args) {

        String.valueOf(null);
//        Main.println(getLuckyFloorNumber(11));
//        Main.println(packNumbers(Arrays.asList(5, 5, 5, 7, 7, 3, 3, 3, 7, 0, 0, 6)));
//        Main.println(packNumbers(Arrays.asList(5, 5, 6)));
//        Main.println(pack(Arrays.asList(5, 5, 5, 7, 7, 3, 3, 3, 7, 0, 0, 5, 5)));
//        Main.println(getLuckyFloorNumber(13));
    }

}
