package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonMockInterviewParkingLot {

    int big = 0;
    int medium = 0;
    int small = 0;

    public AmazonMockInterviewParkingLot(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {

        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            } else {
                return false;
            }

        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            } else {
                return false;
            }
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {
        AmazonMockInterviewParkingLot parkingSystem = new AmazonMockInterviewParkingLot(1, 1, 0);
        parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
        parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
        parkingSystem.addCar(3); // return false because there is no available slot for a small car
        parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already
    }
}
