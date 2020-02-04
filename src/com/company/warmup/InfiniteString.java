package com.company.warmup;

import com.company.Main;

public class InfiniteString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        if(s == null || n == 0) return 0;
        long times = n / s.length();
        long mod = n % s.length();

        long count = s.chars().filter(c -> c == 'a').count();
        long remCount = s.substring(0, (int) mod).chars().filter(c -> c == 'a').count();
        return times * count + remCount;
    }

    public static void main(String[] args) {
        String s = "a";
        Main.println(repeatedString(s, 1000000000));

    }
}
