package com.chefmic.linkedin.frequency_1;

import java.util.ArrayList;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
//���͵�DP�� �㲻���ú�GPS �滮·�� 
public class Triangle {
//bottom up ���� 	
	                          //��һ��arraylist��ʾ�����εĸ߶�(���)/�ڶ���arraylist��ʾ����Ŀ��
	public int miniumTotal(ArrayList<ArrayList<Integer>> triangle){
		if(triangle==null||triangle.size()==0){
			return 0;
		}
		int n=triangle.size(); //�߶�
		//Ԥ���������[][]�����ǵ�������� ����ɵ���Сsum
		int[][] sum=new int[n][n];
       //�ͻ����˴����ϵ���������һ�� ��һ��Ԥ�������
		
		//��triangle���һ�и��Ƶ�Ԥ�����������һ��   [4,1,8,3]
		for(int i=0;i<n;i++){
			sum[n-1][i]=triangle.get(n-1).get(i);
		}
		 
		//Ȼ��������ٸ������һ�п�ʼ����DP.����һ������ϵĸ����ߵ������Ҫ���ٶ���sum 
	//   [6,5,7],
	//  [4,1,8,3]  eg 6������Ӿ���ȡ 4+6��1+6��min Ȼ��ȫ������һ���DP ֱ��sum[0][0]
	         //ÿ����µ��ϱ�����ȥ
		for(int i=n-2;i>=0;i--){
			      //�����ұ�����ȥ
			for(int j=0;j<triangle.get(i).size();j++){
				
				sum[i][j]=Math.min(sum[i+1][j], sum[i+1][j+1])+ triangle.get(i).get(j);
			}
		}
		return sum[0][0];
		
		
		
		
		
		//sum��������������
//	    [2],         [0][0]��[1][0]��[1][1]��С�ĵó�
//	    [3,4],       [1][0]��[1][1]��[2][0],[2][1]��[2][1],[2][2]�еó� �Դ�����
	//  [6,5,7],
	//  [4,1,8,3]
		
		
		
		
		
		
	}
	
	
	
	

}
