package com.company.leetcode;

public class AmazonMockInterviewReverseString {

    public String reverseStr(String s, int k) {

        for (int i = 0; i < s.length(); i++) {
            reverseStr(s, i, k);
            i += 2 * k;

            if(i > s.length()){
                break;
            }
//            if(s.length() - i < k){
//                reverseStr(s, i, s.length() - i);
//            }
//            else if (s.length() - i >= k && s.length() - i < 2 * k){
//                reverseStr(s, i, k);
//            }
        }

        return  "";
    }

    private void reverseStr(String s, int i, int k) {

    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {
        AmazonMockInterviewReverseString solution = new AmazonMockInterviewReverseString();
        println(solution.reverseStr("abcdefg", 2));
    }
}
