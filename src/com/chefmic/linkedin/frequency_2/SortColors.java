package com.chefmic.linkedin.frequency_2;

//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
//1��ֻ��012���������� ����012 ���� 
//O(n)�ⷨ ����ָ��
//3point һ�α������Ը㶨��0��ָ���ͷ��ʼ 2��ָ���β�Ϳ�ʼ   ɨ�赽0�� curr��0ָ�������λ�� Ȼ��0ָ��++ 
//ɨ�赽2�;�curr��2��λ�� Ȼ��2--  �����A[curr]=1 ��curr++
public class SortColors {
	public void sortColors(int[] A) {
		 if(A==null||A.length==0){
	            return;
	        }
	        int zero=0;
	        int two=A.length-1;
	        int i=0;
	        while(i<=two){
	            if(A[i]==0){
	                swap(A,zero,i);
	                zero++;
	                i++;
	            }else if(A[i]==1){
	                i++;
	            }else{
	                swap(A,two,i);
	                two--;
	            }
	            
	        }
	    }

	public void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

}
