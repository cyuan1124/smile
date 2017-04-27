package com.chefmic.linkedin.frequency_3;
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
//�����˴����ϵ����� ccԭ��
//�޷���ÿһ��������һ�ֿ��� ������һ�ֿ��� recursion
//�������������ߵ��յ�x y==0 ����һ��qnique���߷�

//recursion�ⷨleetcode��ʱ
//�����о�Ԥ����ķ��� 
//��Ϊ��Ŀ������M N�������100 ���ǾͰɵ�������100x100�ľ����Ԥ������
//���½ǵ�ĳ�����ӵľ��� ��ʱ�ж����ֿ��ܵ�path �ȷ�˵ways[5,10]����һ����6��11�ľ����unique path����

public class UniquePaths {
	
	  public int uniquePaths(int m, int n) {
		int[][] ways=new int[m][n];
		ways[0][0]=1; //��ʼ һ���߷�  
		// ��Ϊ�����ϵ����ºʹ����µ����� path����һ���� ����0 0����Ϊ�յ�
		for(int i=0;i<m;i++){
			ways[i][0]=1;  // �������ڵ������� ������ֻ��1��· ���ű���
		}
		
		for(int j=0;j<n;j++){
			ways[0][j]=1;
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				//��Ϊ�ߵ�i j�޷�2�ֿ���  ��[i-1][j]����һ������
				//���ߴ� [i][j-1]����һ������
				//��ô �޷��ǰ�����2�ֵ��߹��������е������������ ����i j���ܵ�unique path����
				ways[i][j]=ways[i-1][j]+ways[i][j-1];
			}
		}
		return ways[m-1][n-1]; //-1 ����Ϊ�±�Ĺ�ϵ
	  }
	  
	  
	  
//	   ���������ǶԵ� ����leetcode��ᳬʱ
//	  public int uniquePaths(int m, int n) {
//			// Ϊʲô��x==0||y==0�أ���Ϊ�ߵ�����ֻ��ֻ�����ű�����һ��·���� ����return 1
//			  if(m==0&&n==0){
//		        	return 1;
//		        }
//		  return (uniquePaths(m-1, n)+uniquePaths(m, n-1));  
//		  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
