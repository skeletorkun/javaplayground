package com.company.yilu;

import com.company.Main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class question2 {

    /**
     * Checks if a string is a rotation of the other
     *
     * @param s1
     * @param s2
     * @return
     */
    static boolean isRotation(String s1, String s2) {


        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }

        String rotated = s1;
        for (int i = 0; i < s1.length(); i++) {
            rotated = rotated.substring(1) + rotated.toCharArray()[0]; // put the first char to the end
            if (rotated.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "orkunozen";
        String s2 = "kunozenor";

        Main.println(isRotation(s1, s2));
    }

}
