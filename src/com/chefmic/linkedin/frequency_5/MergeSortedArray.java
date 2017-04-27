package com.chefmic.linkedin.frequency_5;
//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//Note:
//You may assume that A has enough space to hold additional elements from B. 
//��仰��˵ A�и�Ԫ�� B��n��Ԫ��
//The number of elements initialized in A and B are m and n respectively.
//A��B���Ƕ�sorted�������ǲ���ͷ��ʼ��˭С�����Ǵ�A��B��β�Ϳ�ʼ��˭��
//˭��˭�ͷŵ�A��[(a���һ�������ݵ��±�)+(b.length)],Ȼ���--�±��--,����ȥ�ͺ���ͨmergesortһ��

//��cc��9_1��ȫһ��
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public void merge(int[] A, int m, int[] B, int n) {
        // index here

        if (n != 0 && m != 0) {
            int lastA = m - 1;
            int lastB = n - 1;
            int lastResult = m + n - 1;

            while (true) {
                if (A[lastA] <= B[lastB]) {
                    A[lastResult] = B[lastB];
                    lastResult--;
                    lastB--;
                    if (lastB < 0) {
                        break;
                    }
                } else if (A[lastA] > B[lastB]) {
                    A[lastResult] = A[lastA];
                    lastResult--;
                    lastA--;
                    if (lastA < 0) {
                        break;
                    }
                }
            }
            if (lastA < 0) {
                for (int i = lastB; i >= 0; i--) {
                    A[lastResult] = B[lastB];
                    lastResult--;
                    lastB--;
                }
            }
            if (lastB < 0) {
                for (int i = lastB; i >= 0; i--) {
                    A[lastResult] = A[lastA];
                    lastResult--;
                    lastA--;
                }
            }
        }
        if (m == 0 || A.length == 0 || A == null) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
        }
    }

}
