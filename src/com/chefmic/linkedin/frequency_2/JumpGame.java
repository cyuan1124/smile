package com.chefmic.linkedin.frequency_2;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false. 
//1.dp���� ��ȫ���� word break1 O��N2�� 2. ���� maximum sub array ɨ�����鲢��¼
//��ʱ����Զ����һ����i + A[i]������Ѿ��ȵ�ǰ����С��maxLen < i ��ô�϶��ǲ����� return false
public class JumpGame {

	// ����2
	public boolean canJump(int[] A) {
		int len = A.length;
		int maxLen = 0;
		for (int i = 0; i < len; i++) {
			if (maxLen < i) {
				return false;
			}
			maxLen = Math.max((i + A[i]), maxLen);
		}
		return true;
	}


//DP ����
//	1.dp���� ��ȫ���� word break1   
//	2��forѭ�� ÿ����ѭ��������A[j]�ܲ������� iλ �ܵĻ���can[i]=true Ȼ�����һλ�ܲ���true
	    public boolean canJump2(int[] A) {
	        boolean[] can = new boolean[A.length];
	        can[0] = true;
	        
	        for (int i = 1; i < A.length; i++) {
	            for (int j = 0; j < i; j++) {
	                if (can[j] && j + A[j] >= i) {
	                    can[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return can[A.length - 1];
	    }
	

}
