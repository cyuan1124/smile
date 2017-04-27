package com.chefmic.linkedin.frequency_2;
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example,
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
//http://oj.leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
	
//��Ϊÿ��column���ǿ��1 ��ô���=���+(��ǰˮ��߶�-��ǰcolumn�߶�)*1 traverseһ�߼���
//���Թؼ�����ǰiˮ��߶� ,i���column��ˮ��߶� ����������������ҽڵ�����ߵ�2���Ķ̰������(����Ŀ��ͼ��֪����)
//���Խ���2������ һ���Ǵ����� 1~iʱ��������߸߶�
//һ���Ǵ�������� length-2 ��i���ұ���߸߶�
//Math.min(left[i],right[i])���ǵ�ǰˮ��߶�
public int trap(int[] A) {
      if(A.length==0){
    	  return 0;
      }
      int[] left=new int[A.length];
      int[] right=new int[A.length];
       //һάdp��ʼ���� 		
      left[0]=A[0];
      //dp
      for(int i=1;i<A.length;i++){
    	  left[i]=Math.max(left[i-1], A[i]);
      }
      //һάdp��ʼ����
      right[A.length-1]=A[A.length-1];
    //dp
      for(int i=A.length-2;i>=0;i--){
    	  right[i]=Math.max(right[i+1],A[i]);
      }
      
      int sum=0;
      //ͷ-1/β+1 �ǿ� ���Բ�����ˮ
      for(int i=1;i<A.length-1;i++){
    	  sum=sum+ Math.min(left[i], right[i])-A[i];
      }
      return sum;     
}
}
