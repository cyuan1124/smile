package com.chefmic.linkedin.newQuestion;
//Given an array of integers, every element appears three times except for one. Find that single one. 

public class Singlenumber2 {
    public int singleNumber(int[] A) {
        int bit = 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            bit = 0;
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    bit++;
                }
            }
            bit = bit % 3;
            result = result | bit << i;
        }
        return result;
    }

}
