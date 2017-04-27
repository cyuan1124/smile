package com.chefmic.linkedin.frequency_2;

import java.util.Arrays;

//Given a non-negative number represented as an array of digits, plus one to the number.
//                                        (λ������)
//The digits are stored such that the most significant digit is at the head of the list.
//һ������eg[9,9,9] ����999 Ȼ��Ҫ+1 ���һ�������ʽ���� 
//���� ��λ ��λ �� linkedlist���˼·���
//ע�� �� +1��nλ��n+1λ�� Ҫ����һ�����ȸ�����������
public class PlusOne {
	 public int[] plusOne(int[] digits) {
	   if(digits==null){return null;}
	   int current=digits.length-1; //eg [9,9,9] �Ǵ����һλ����
	 boolean overflow=false;   

	 while(current>=0){
		 if(digits[current]+1>9){
			 digits[current]=0;
			 overflow=true;
			current--;
		 }else{     //4 7 9  +1 ֮�� 4 7 0  7+1=9��0 ���� return 480
			 digits[current]=digits[current]+1;
			 return digits; 
		 }
	 }
		 //��������� ��ûreturn ˵�� ��λ +1����0  ��Ҫ����λ��
		 if(overflow){
			 int[] newDigits=new int[digits.length+1];
			 System.arraycopy(digits,0,newDigits,1,digits.length);
			 newDigits[0]=1;
			 newDigits[1]=0;
			 return newDigits;
			 
			 
		 }
		 
	 
	return digits;
		  }
	 public static void main(String[] args) {
		 int[] digits = {9,9,9};  
	//   int[] digits = {0};  
	     System.out.println(Arrays.toString(new PlusOne().plusOne(digits))); 		
	}
 
}

