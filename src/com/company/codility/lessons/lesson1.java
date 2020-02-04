package com.company.codility.lessons;

import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class lesson1 {

    public static int solution(int N) {
        Main.println("N = " + N);


        // write your code in Java SE 8
        int result = 0;

        String s = Integer.toBinaryString(N);
        Main.println("s = " + s);

        if(s.indexOf('1') == s.lastIndexOf('1') || s.indexOf('0') == -1){
            return 0;
        }

        char[] chars = s.toCharArray();
        List<Integer> indexes = new ArrayList<>();
        int maxGap = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                indexes.add(i);
                int listSize = indexes.size();
                if(listSize > 1){
                    Integer previousIndex = indexes.get(listSize - 2);
                    int currentGap = i - previousIndex - 1;
                    maxGap = Math.max(maxGap, currentGap);
                }
            }
        }

        Main.println("step2 " + maxGap);


        return maxGap;
    }

    public static void main(String[] args) {
//        Main.println(solution(2147483647));
        Main.println(solution(1041));
//        Main.println(solution(2147483647));
    }

}
