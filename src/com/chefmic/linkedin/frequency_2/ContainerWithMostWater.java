package com.chefmic.linkedin.frequency_2;
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container
// �ȷ�˵����height[n]��  n�� x(��) height[n] y ��  
//
//                |                      height[3]=4           //�̰�ԭ��
//                |     height[2]=2        |            ��ô water����� ���� (4-2)*Min(height[2],height[3])=2*2=4
//                |       |                |
//                |       |                |         
//                |����������������������������������������������������������������������������������
//                        2                4
//                                                 ���                
//����:����һ������height[n];i,j����������±꣬�ҵ���j-i��*min(heigth[i],height[j])��������

//˫ָ�� i��������ɨ�� j��������ɨ�� 

public class ContainerWithMostWater {
public int maxArea(int[] height) {
   int i=0;
   int j=height.length-1;
   int maxArea=0;
   while(i<j){
	   //��ָ��i��ߵĸ߶ȶ̣�����ˮͰԭ��,�̱߾������ ��ô ������ô���Ƕ����
	   //��Ӱ������Զ̱����� �����ܲ��ܸ���
	   if(height[i]<height[j]){
		   if((j-i)*height[i]>maxArea){
			   maxArea=(j-i)*height[i];}
			   i++;
		   }else{  //��ָ�� j�Ǳߵĸ߶Ȱ�
			   if((j-i)*height[j]>maxArea){
				   maxArea=(j-i)*height[j];}
				   j--;
			   }
		 
   }
return maxArea;
			
		
		
    }
}
