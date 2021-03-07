package com.company.leetcode;

import com.company.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return null;
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        Main.println(Arrays.toString(twoSum(nums, 9)));
    }

}
