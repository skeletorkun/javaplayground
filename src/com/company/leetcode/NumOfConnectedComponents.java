package com.company.leetcode;

import java.util.*;

public class NumOfConnectedComponents {


    public int countComponents(int n, int[][] edges) {

        Set<Set<Integer>> components = new HashSet<>();

        for (int[] edge : edges) {
            Set<Integer> set = new HashSet<>();
            set.add(edge[0]);
            set.add(edge[1]);
            components.add(set);
        }


        components = checkForUnionsRecursive(components);

        println(components);

        Set<Integer> uniqueIntegers = new HashSet<>();
        components.forEach(uniqueIntegers::addAll);
        return components.size() + n - uniqueIntegers.size();
    }

    private Set<Set<Integer>> checkForUnionsRecursive(Set<Set<Integer>> components) {

        boolean foundSthToMerge = false;
        Set<Set<Integer>> unions = new HashSet<>();

        for (Set<Integer> c : components){

            boolean anyMatch = false;
            for(Set<Integer> u : unions){
                if(!u.equals(c) && !Collections.disjoint(u, c)){
                    anyMatch = true;
                    foundSthToMerge = true;
                    u.addAll(c);
                }
            }

            if(!anyMatch){
                unions.add(c);
            }
        }
        println(unions);

        if(foundSthToMerge){
            return checkForUnionsRecursive(unions);
        }
        else{
            return unions;
        }
    }


    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        NumOfConnectedComponents solution = new NumOfConnectedComponents();

        int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 4}};
        solution.countComponents(5, edges);
    }
}
