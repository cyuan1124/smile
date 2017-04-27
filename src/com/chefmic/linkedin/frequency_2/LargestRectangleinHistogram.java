package com.chefmic.linkedin.frequency_2;

import java.util.Stack;


//For example,
//Given height = [2,1,5,6,2,3],
//return 10. 
//
//�ȷ�˵��һ��ֱ��ͼ height = [2,1,5,6,2,3],����ÿ��������� ֱ��ͼ��ÿ�����ֵĸ߶�
//Ȼ��Ҫ��ֱ��ͼ���������εĸ߶�  �ȷ�˵�� 215623�� ���ľ��ξ���56 2��������ɵ�  2��5=10
//�� window sliding���������� ����maximum sub array
//�ұ�һֱ���ұ��� Ȼ��ÿ����һ�ο�����ߵ��������һ��ջ����(ջ��������index) ջ����Ҫά���ϸ���� 
//eg:�ȷ�˵ ������1432  �±���0123
//һ��ʼpush1 stack.push(index-0); ��ʱû��whileѭ�� ���������
//Ȼ��134 ��û�н�while Ȼ�� �����������
//Ȼ�� ��Ҫװ2��ʱ�򣨴�ʱi��3�� ����whileѭ�� 
//ѭ����һ�� currentHeight2 ��4 �� ��ʱ h��4 w��1  max���³�4
//ѭ���ڶ��� currentHeight2 ��3 �� ��ʱ h��3 w��2 max ���³�6
//Ȼ���3Ҳ������ stack����� 1 2 Ȼ�����ұ��ټ��� slides
public class LargestRectangleinHistogram {

	public int largestRectangleArea(int[] height) {
	      if(height==null||height.length==0){
	    	  return 0;
	      }  
	Stack<Integer> stack=new Stack<Integer>();
	int max=0;
	//slicd window
	for(int i=0;i<=height.length;i++){
		 //Ŀǰ�Ҳ໬��������(i�����ҽ�)��Ҫ�ǵ��Ѿ�Խ���˾��� -1 ûԽ��߶Ⱦ���height[i]   
		int currentHeight=(i==height.length)?-1:height[i];
		//���height���ϸ�Ҫ���ֵ����� 
		//�ȷ�˵������ 1342
		//�Ҳ���134֮�� ��Ҫ�� 34��pop�������ܲ�2 ֮�����1 2                                          index
	 	//���whileѭ������pop 3 4�Ĺ���       //ע�� stack������index ������currentHeight��height[stack.peek()]��
		while(!stack.isEmpty()&&currentHeight<=height[stack.peek()]){
			//��Ϊstack�ڵ�int�ǵ��������� ���height�ǵ�����height����̵��Ǹ��Ѿ���󵯳�����height[1]=3
			int h=height[stack.pop()];
			//eg: pop3,4����֮�� index����ֻ��0��һ��Ԫ���� ,Ȼ���ʱpeek��1��2С ���Դ�ʱwidth��3-0-1=2;
			int w=stack.isEmpty()?i:i-stack.peek()-1;
	        max=Math.max(max,h*w);//����pash2��ʱ�� �����2x3 
		}
	       stack.push(i); //ע��  stack ����װ����i��������index
	      
	}
	
return max;	
	}
	

}
