package com.company.booking;

import com.company.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class booking2 {


    // Complete the packNumbers function below.
    static List<String> packNumbers2(List<Integer> arr) {

        List<String> res = new ArrayList<>();
        int runner = 0;
        for (int i = 0; i < arr.size(); i++) {

            runner = i;
            Integer current = arr.get(i);
            while (arr.size() > runner + 1 && arr.get(runner) == current) {
                runner++;
            }

            int count = runner - i;
            if (count > 1) {
                res.add("'" + current + ":" + count + "'");
            } else {
                res.add(String.valueOf(current));
            }

            if (runner != current) {
                i = runner - 1;
            }


        }
        return res;

    }

    private static List<String> packNumbers(List<Integer> list) {

        ArrayList result = new ArrayList<String>();

        if (list.size() > 0) {

            int last = list.get(0);
            int lastCount = 0;

            for (int i = 1; i < list.size(); i++) {
                int value = list.get(i);
                lastCount++;
                if (value != last) {
                    String str = String.valueOf(last);
                    if (lastCount > 1) {
                        str += ":" + lastCount;
                    }
                    result.add(str);
                    lastCount = 0;
                    last = value;
                }
            }
            String str = String.valueOf(last);
            if (lastCount > 1) {
                str += ":" + lastCount;
            }
            result.add(str);

        }
        return result;

    }

    public static void main(String[] args) {
//        Main.println(getLuckyFloorNumber(11));
//        Main.println(packNumbers(Arrays.asList(5, 5, 5, 7, 7, 3, 3, 3, 7, 0, 0, 6)));
        Main.println(packNumbers(Arrays.asList(5, 5, 6)));
//        Main.println(pack(Arrays.asList(5, 5, 5, 7, 7, 3, 3, 3, 7, 0, 0, 5, 5)));
//        Main.println(getLuckyFloorNumber(13));
    }

}
