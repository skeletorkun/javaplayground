package com.company.basics;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeChecker {

    Set<Integer> primes = new HashSet<>();

    public void checkPrime(Integer... args){

        for (int i : args){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    private boolean isPrime(int i) {

        if(i < 2){
            return false;
        }
        for (int j = 2; j < i; j++) {
            if(i % j == 0){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        new PrimeChecker().checkPrime(1,2,3,4,5);
    }
}