package com.company.leetcode;

import com.company.Main;

import java.util.*;

public class WordSearch {


    public boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();

        if (chars.length > board.length * board[0].length) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == chars[0]) {
                    // begin

                    if (lookup(board, new Tuple(i, j, 0, new ArrayList<>()), word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    class Tuple {
        int i, j;
        int target = 0;
        List<Tuple> path = new ArrayList<>();

        public Tuple(int i, int j, int target, List<Tuple> prevPaths) {
            this.i = i;
            this.j = j;
            this.target = target;

            path.addAll(prevPaths);

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;
            Tuple tuple = (Tuple) o;
            return i == tuple.i && j == tuple.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        public boolean hasBeenHereBefore() {
            return path.contains(this);
        }
    }

    private boolean lookup(char[][] board, Tuple start, String word) {

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();

            if (board[current.i][current.j] == word.charAt(current.target)) {

                if (current.hasBeenHereBefore()) {
                    continue;
                }

                println("visiting " + board[current.i][current.j]);

                if (current.target == word.length() - 1) {
                    return true;
                }

                current.path.add(current);

                // go right
                if (current.i < board.length - 1) {
                    queue.add(new Tuple(current.i + 1, current.j, current.target + 1, current.path));
                }

                // go left
                if (current.i > 0) {
                    queue.add(new Tuple(current.i - 1, current.j, current.target + 1, current.path));
                }

                // go up
                if (current.j > 0) {
                    queue.add(new Tuple(current.i, current.j - 1, current.target + 1, current.path));
                }

                // go down
                if (current.j < board[0].length - 1) {
                    queue.add(new Tuple(current.i, current.j + 1, current.target + 1, current.path));
                }


            }
        }

        return false;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        WordSearch instance = new WordSearch();

        // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"

//        char[][] board = new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//        Main.println(instance.exist(board, "ABCB"));

//        char[][] board = new char[][]{
//                {'A','B','C',},
//                {'A','E','D',},
//                {'A','F','G'}
//        };
//
//
//        Main.println(instance.exist(board, "ABCDEFG"));


        char[][] board = new char[][]{
                {'a', 'a', 'b', 'a', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'b', 'a'},
                {'b', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'b', 'b', 'a', 'b', 'a'},
                {'b', 'a', 'a', 'a', 'a', 'b'}};


        Main.println(instance.exist(board, "bbbaabbbbbab")); // false
    }

}
