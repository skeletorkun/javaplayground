package com.company.leetcode;

import com.company.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        
        permute(nums, new ArrayList<>());

        return res;
    }

    public void permute(int[] nums, List<Integer> permutation){

        if(nums.length == 0){
            res.add(permutation);
            return;
        }

        for (int i : nums){
            ArrayList<Integer> copy = new ArrayList<>(permutation);
            copy.add(i);
            permute(Arrays.stream(nums).filter(j -> j != i).toArray(), copy);
        }
    }

    public static void main(String[] args) {

        Permutations instance = new Permutations();
        Main.println(instance.permute(new int[]{1,2,3}));
    }

}
