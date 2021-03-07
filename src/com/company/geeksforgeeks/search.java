package com.company.geeksforgeeks;

import com.company.Main;

import java.util.StringJoiner;

public class search {
    static class Pair {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                    .add("first=" + first)
                    .add("second=" + second)
                    .toString();
        }
    }

    public static Pair findIndexes(long v[], long x) {

        Pair pair = new Pair(-1, -1);

        int first = -1;
        int last = -1;
        for (int i = 0, j = v.length - 1;  i < v.length || j > 0; i++, j--) {

            if(v[i] == x && first == -1){
                first = i;
            }
            if(v[j] == x && last == -1){
                last = j;
            }

            if(first != -1 && last != -1){
                pair.first = first;
                pair.second = last;
                break;
            }
        }

        return pair;
    }

    public static void main(String[] args) {
//        Main.println(findIndexes(new long[]{1, 3, 5, 5, 5, 5, 7, 123, 125}, 5));
        Main.println(findIndexes(new long[]{2,3,4}, 4));
    }

}
