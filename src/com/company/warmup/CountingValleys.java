package com.company.warmup;

import com.company.Main;

public class CountingValleys {

    // DDUUDDUDUUUD
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        String step;
        int altitude = 0;
        int valleyCount = 0;
        for (int i = 0; i < n; i++) {

            step = s.substring(i, i + 1);
            if (step.equals("U")) {
                altitude++;
            } else {
                altitude--;
            }

            if (altitude < 0 && step.equals("U") && i >= 2) {

                String stepPrev = s.substring(i - 1, i);
                String stepPrevPrev = s.substring(i - 2, i - 1);
                if (stepPrev.equals("D") && stepPrevPrev.equals("D")) {
                    valleyCount++;
                }
            }
        }

        return valleyCount;
    }

    public static void main(String[] args) {
        String s = "DDUUDDUDUUUDDDUUDDUDUUUD";
        Main.println(countingValleys(s.length(), s));

    }
}
