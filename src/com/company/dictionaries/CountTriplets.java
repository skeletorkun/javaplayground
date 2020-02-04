package com.company.dictionaries;

import com.company.Main;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, List<Long>> numWithIndexes = new HashMap<>();

        for (long i = 0; i < arr.size(); i++) {

            Long num = arr.get((int) i);
            List<Long> index = new ArrayList<>();
            if (numWithIndexes.containsKey(num)) {
                index = numWithIndexes.get(num);
            }

            index.add(i);
            numWithIndexes.put(num, index);
        }

        AtomicLong totals = new AtomicLong(0L);

        numWithIndexes.entrySet().stream()
                .filter(x -> {
                    Long first = x.getKey();
                    Long p1 = first * r;
                    Long p2 = p1 * r;
                    return numWithIndexes.containsKey(p1) && numWithIndexes.containsKey(p2);
                })
                .forEach(longListEntry -> {
                    Long first = longListEntry.getKey();
                    Long p1 = first * r;
                    Long p2 = p1 * r;

                    List<Long> firstIndexes = longListEntry.getValue();
                    List<Long> p1Indexes = numWithIndexes.get(p1);
                    List<Long> p2Indexes = numWithIndexes.get(p2);

                    firstIndexes.forEach(i -> {
                        p1Indexes.stream()
                                .filter(j -> j > i)
                                .forEach(j -> {

                                    long p2sWithK = p2Indexes.stream()
                                            .filter(k -> k > j)
                                            .count();

                                    totals.addAndGet(p2sWithK);
                                });

                    });
                });

        return totals.get();
    }


    public static void main(String[] args) {

//        String str = "1 2 2 4";
//        String str = "1 5 5 25 125"; long r = 5;
        String str = "1 3 9 9 27 81";
        long r = 3;

        List<Long> arr = Arrays.stream(str.split(" ")).map(Long::valueOf).collect(Collectors.toList());
        long l = countTriplets(arr, r);
        Main.println("result " + l);
    }

}
