package com.company.leetcode;

import com.company.Main;

public class BinarySearchNextGreatestChar {

    public char nextGreatestLetter(char[] letters, char target) {

        for (int i = 0; i < letters.length; i++) {
            if(letters[i] > target){
                return letters[i];
            }
        }
        return letters[0];
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        BinarySearchNextGreatestChar i = new BinarySearchNextGreatestChar();
        assert i.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a') == 'c';
        assert i.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') == 'f';
        assert i.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd') == 'f';
        assert i.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g') == 'j';
        assert i.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j') == 'c';
        assert i.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k') == 'c';




    }

}
