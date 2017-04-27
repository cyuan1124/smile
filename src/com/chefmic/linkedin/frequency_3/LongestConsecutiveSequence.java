package com.chefmic.linkedin.frequency_3;

import java.util.HashMap;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity. 

//��������С���һ��û��sort���������ҵ�|��������|��Ԫ��  �������ڵĳ���
 
public class LongestConsecutiveSequence {
	 public int longestConsecutive(int[] num) {
         HashMap<Integer,Boolean> hs=new HashMap<Integer, Boolean>();	        
	 for(int i:num){
		 hs.put(i, false);
	 }   
	 int maxLength=1;
	 for(int i:num){
		 if(hs.get(i)==true){ //�������true��ʾ�Ѿ����ʹ���
			 continue;
		 }
		 int temp=i;
		 int current_maxLength=1;
		 //������tempʱ��  ��hashmap����temp+1 ��temp-1 ������û�к�temp������
		 //����ҵ��˾���temp++/temp-- �����������
		 
		 while(hs.containsKey(temp+1)){
			 temp++;
			 current_maxLength++;
			 hs.put(temp, true); //��ʾ���++��temp���ڵ���һ��Consecutive Sequence�Ѿ��ҹ� ��������
		 }
		 //���while�������,˵����temp���Consecutive Sequence �Ѿ�������
		 //���ڿ�ʼ�ұ�tempС��
		 temp=i;
		 while(hs.containsKey(temp-1)){
			 current_maxLength++;
			 temp--;
		   hs.put(temp, true);
		 }
		//��ʱ����temp��� Consecutive Sequence�Ѿ��ҵ�
		 //Ȼ���ٰ���������ĳ��Ⱥ�֮ǰ�����ĳ���ȡmax ���С�
		 maxLength=Math.max(maxLength, current_maxLength);
		 
	 }
	 return maxLength;
	 }
}
