package com.chefmic.linkedin.frequency_2;

//Given an unsorted integer array, find the first missing positive integer.
//
//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.
//
//Your algorithm should run in O(n) time and uses constant space. 
//�����������������ֵ�һ��ȱʧ��������  0���ùܣ�(����������Թ�0Ҫ��Ҫ)
//http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html

public class FirstMissingPositive {
	// �ȷ�˵ -5��-2��0��3��4 ��ô��һ�� first MISSING positive ����1
	// ��ôɨ��2�����飬 ��һ�� �������� Ȼ��ɨ������������С��A.length,����ֵ��i
	// �Ͱ���������ŵ�num[i-1]λ����ȥ eg 1�ͷŵ�num[0] λ
	// (eg:Ϊʲô����1λ�����A={0} ��ô�ڶ���iֻ��=0��ʼ���� Ȼ��A[0]==0 returnԪ�س���+1 �ͱ�2��)
	// ���ú� ��ȥ��1ɨ������ ��һ���±겻����ֵ�þ���first missing possible
	// �������match�� �ȷ�˵12345 ��ôfmp���� A.length+1 6
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		for (int i = 0; i < A.length; i++) { // A[i]==(i+1)˵���Ѿ��ڶԵ�λ���� ���û�
			while (A[i] > 0 && A[i] <= A.length && A[i] != (i + 1)) {
				//Ϊʲô��while,��Ϊ�㻻��iλ������ҲҪ������ȷλ�á�������һ��i++�� ����iλ�Ͳ�������
				int temp=A[A[i]-1];  //A[i] Ӧ�ô浽A[i]-1;
				if(temp==A[i]){//eg:A[1]��4 A[3] Ҳ��4 ��ô�������;ͻ���ѭ��
					 break;
				}  
				A[A[i]-1]=A[i];
				A[i]=temp;		 
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}

	public static void main(String[] args) {
		int[] A = { 0 };
		int b = new FirstMissingPositive().firstMissingPositive(A);
		System.out.print(b);
	}
}
