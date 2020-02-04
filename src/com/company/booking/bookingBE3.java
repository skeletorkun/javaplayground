package com.company.booking;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bookingBE3 {


    // Complete the howManyAgentsToAdd function below.
    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {

//        callsTimes.get()
//        for (List<Integer> call : callsTimes){
//            Instant start = Instant.ofEpochMilli(call.get(0));
//            Instant end = Instant.ofEpochMilli(call.get(0));
//        }

        return 1;
    }


    public static void main(String[] args) {

        List<List<Integer>> calltimes = new ArrayList<>();
        Arrays.asList(1481122000, 1481122020);
        Arrays.asList(1481122000, 1481122040);
        Arrays.asList(1481122030, 1481122035);

        howManyAgentsToAdd(1, calltimes);
    }

}
