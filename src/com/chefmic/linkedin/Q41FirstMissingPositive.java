package com.chefmic.linkedin;

import org.junit.Test;

/**
 * Created by cyuan on 4/16/17.
 */
public class Q41FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{1, 2, 3}));
    }

}
