package com.company.leetcode;

import com.company.Main;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;

public class Subsets {

    public Set<List<Integer>> permute(List<Integer> nums) {

        Set<List<Integer>> res = new HashSet<>();

        permute(res, nums);

        return res;
    }

    public void permute(Set<List<Integer>> subsets, List<Integer> nums){

        subsets.add(nums);

        if(nums.size() == 0){
            return;
        }

        for (int i = 0; i < nums.size(); i++) {

            List<Integer> copy = new ArrayList<>(nums);
            copy.remove(i);
            permute(subsets, copy);
        }
    }

    public static void main(String[] args) {

        Subsets instance = new Subsets();
        Main.println(instance.permute(Arrays.asList(1,2,3)));
    }

}
