package com.chefmic.linkedin.frequency_3;
//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array A = [1,1,2],
//
//Your function should return length = 2, and A is now [1,2]. 
//2��ָ�������������fastɨ��2�����ڵĲ�һ��ʱ�� slow �Ŷ� 
public class RemoveDuplicatesfromSortedArray {

	  public int removeDuplicates(int[] A) {
	      
		  if (A == null || A.length <= 1) {
		      return A == null ? 0 : A.length;
		    }
		    int index = 1; //indexΪ��ָ��
		    //i�ǿ�ָ��
		    for (int i = 1; i < A.length; ++i) {
		      if (A[i] != A[i - 1]) {//��ɨ�赽��ͬʱ�� ���ż�
		        A[index++] = A[i];
		      }
		    }
		    return index;}
	public static void main(String[] args) {


	}

}
