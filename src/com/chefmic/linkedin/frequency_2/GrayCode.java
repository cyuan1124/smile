package com.chefmic.linkedin.frequency_2;

import java.util.ArrayList;

//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
//For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//Note:
//For a given n, a gray code sequence is not uniquely defined.
//
//For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

//������ת��  ��������Ƴ���  ��� һ����ͷת���׵�·��
//�����붨������ڶ��������ֱ任ʱ�� �������ж���bit ÿ��ֻ�ܱ�һ�� bit
//�����������һ��  �����2λbit ��ôһ������2*2��=4������ �㷵�صĽ��һ��Ҫ���������ֵ�intֵ������ ����ÿ2��֮������һλ bit
//�ȷ�˵ n=4ʱ�� ��Ҫ����16������ ��0000��ʼ ������������ ÿ��֮��1 bit �� ����һ��˳�򼴿ɡ�
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//Try one more example, n = 3:
//
//000 - 0
//001 - 1
//011 - 3
//010 - 2
//110 - 6
//111 - 7
//101 - 5
//100 - 4 
//����������ô n = 2: [0,1,3,2] and n=3: [0,1,3,2,6,7,5,4]
//ǰ����һ����  ����6754 ����  [2+4,3+4,1+4,0+4] 0132������2310 +4  (3-1)^2
//����ÿ�εݹ��ҳ�ǰһ��Ȼ���ٷ����� +(n-1)^2����  

public class GrayCode {
	  public ArrayList<Integer> grayCode(int n) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
		  if(n==0){  //�ݹ�Ľ������� 0bit����0 ����ô�涨
			  result.add(0);
			  return result;
		  }
		 ArrayList<Integer> preResult=grayCode(n-1);
		 result.addAll(preResult);
		 //�¼ӵĲ��ְ���һ�������żӡ�
		 for(int i=preResult.size()-1;i>=0;i--){
			result.add(preResult.get(i)+(int) Math.pow(2, n-1));
		 }
		return result;  
	    }
}
