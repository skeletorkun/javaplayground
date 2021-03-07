package com.company.amazon;

import com.company.Main;

import java.util.*;

public class TwoSumsMoviesOnFlight {

    /**
     * Question:
     * You are on a flight and wanna watch two movies during this flight.
     * You are given List<Integer> movieDurations which includes all the movie durations.
     * You are also given the duration of the flight which is d in minutes.
     * Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
     * <p>
     * Find the pair of movies with the longest total duration and return they indexes. If multiple found, return the pair with the longest movie.
     * <p>
     * Example 1:
     * <p>
     * Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
     * Output: [0, 6]
     * Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)
     */



    public static void main(String[] args) {

        TwoSumsMoviesOnFlight solution = new TwoSumsMoviesOnFlight();

        solution.twoMovies(Arrays.asList(90, 85, 75, 60, 120, 150, 125), 250);

    }

    class Tuple{

        Integer first, second;
        Integer remainingTime;

        public Tuple(Integer first, Integer second, Integer remainingTime) {
            this.first = first;
            this.second = second;
            this.remainingTime = remainingTime;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Tuple.class.getSimpleName() + "[", "]")
                    .add("first=" + first)
                    .add("second=" + second)
                    .add("remainingTime=" + remainingTime)
                    .toString();
        }
    }

    private void twoMovies(List<Integer> durations, int totalDuration) {


        // index -> remaining duration
        Queue<Tuple> heap = new PriorityQueue<>(Comparator.comparing(o -> o.remainingTime));

        for (int i = 0; i < durations.size() - 1; i++) {

            for (int j = i + 1; j < durations.size(); j++) {
                int tupleTotal = durations.get(i) + durations.get(j);
                int remaining = totalDuration - tupleTotal - 30;
                if(remaining >= 0){
                    heap.add(new Tuple(i,j, remaining));
                }
            }
        }

        Main.println("heap : " + heap.toString());
        Main.println("best : " + heap.poll());

    }
}
