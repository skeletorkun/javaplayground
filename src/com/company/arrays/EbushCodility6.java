package com.company.arrays;

import com.company.Main;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class EbushCodility6 {
    // Complete the maxPrefix function below.


    @Test
    public void verifyLoginPageTitle() {
        String title = "";
        assertEquals("", title);
    }

    static int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{100, 63, 1, 6, 2, 13};
        int x = 6;
        int y = 13;

        int total = solution(x, y, arr);

        Main.println(total);

    }

}
