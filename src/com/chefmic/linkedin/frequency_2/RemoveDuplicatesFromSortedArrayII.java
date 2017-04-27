package com.chefmic.linkedin.frequency_2;
//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//
//Your function should return length = 5, and A is now [1,1,2,2,3]. 

//remvoe 1�Ǽ�ȥ�� ˫ָ�뼴��
//remove 2�� ������������ظ��� 
//��Ȼ��� ����Ҫ����sorted������ +˫ָ�� size(��) ��  i(��)  
//�������� ��������ɨ ɨ������������size++
//��Ϊsize���±�  ��󷵻س���size+1;

public class RemoveDuplicatesFromSortedArrayII {
	
	public int removeDuplicates(int[] A) {
		if(A==null||A.length==0){
			return 0;
		}
		int size=0;
		
		for(int i=1;i<A.length;i++){
		//A[i]==A[size]&&A[size-1]==A[size] ����size����Ѿ���2����ͬ������ ��ô���i�Ͳ��ܲ���
			if(A[i]==A[size]&&A[size-1]==A[size]&&size>0){
				continue;
			}
			A[++size]=A[i];
		}
		return size+1;
	 }
}
