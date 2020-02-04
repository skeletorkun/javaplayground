package com.company.booking;

import com.company.Main;

public class booking1 {


    static int getLuckyFloorNumber(int n) {

        int lucky = 1;
        for (int i = 1; i < n; i++) {

            lucky++;

            while(isUnlucky(lucky)){
                lucky++;
            }

        }
        return lucky;

    }

    static boolean isUnlucky(int i){
        String s = String.valueOf(i);
        return s.contains("4") || s.contains("13");
    }

    public static void main(String[] args) {
//        Main.println(getLuckyFloorNumber(11));
        Main.println(getLuckyFloorNumber(12));
//        Main.println(getLuckyFloorNumber(13));
    }

}
