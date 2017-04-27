package com.chefmic.linkedin.frequency_3;
//Given two numbers represented as strings, return multiplication of the numbers as a string.
//                         �����
//Note: The numbers can be arbitrarily large and are non-negative.


public class MultiplyStrings {
//��λ ��λ˼�� ����385 * 97, ���Ǹ�λ=5 * 7��ʮλ=8 * 7 + 5 * 9 ����λ=3 * 7 + 8 * 9 ��
//	����ÿһλ��һ��Int��ʾ������һ��int[]���档

	
	
	//	1 ��תstring
//	2 �������飬˫��ѭ����������string���ѵ�λ�ĳ˻��ۼӵ�������Ӧ��λ��
//	3 �����λ�����
//	4 ע��ǰ�����corner case
//	
//  һ��˷�    21��31
//   ��ת��     12
//           13
//  ---------------
//           36
//          12
// --------------------
//          156 
//  �� d[i+j]=d[i+j]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
//      ���� d[1]=d[1][0]+d[0][1]=3��1+1��2=5
 // d[i]=�����˷����i��λ֮��  (û�н�λ)	
	
	public String multiply(String num1, String num2) {
//��ת�� ��λ����ǰ ���ڼ��� 
 num1=new StringBuilder(num1).reverse().toString();
 num2=new StringBuilder(num2).reverse().toString();
//even 99*99 is <10000, so ���Գ˻���length�϶��� length1+length2�͹�����;
 int[] d= new int[num1.length()+num2.length()];
for(int i=0;i<num1.length();i++){
	for(int j=0;j<num2.length();j++){
		d[i+j]=d[i+j]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
	}

} 
		
StringBuilder sb = new StringBuilder();  
for(int i=0; i<d.length; i++){  
    int digit = d[i]%10;        // ��ǰ��λ  
    int carry = d[i]/10;        // ��λ .���d[i]>0�Ļ� ���н���ǰ��λȥ 
    if(i+1<d.length){  
        d[i+1] += carry; 
    }  
    sb.insert(0, digit);        // ��Ϊǰ�淴ת�� num1,2 ���� ÿ�ζ��ѵ���λ  ����stringbuilder�ĵ�0λ Ȼ��Խ����Ĳ嵽��ǰ��
}  
		//�������ƺ������
//���Ǳȷ�˵100��100����ǰ��׼����6λ��len3 ����ֻ����10000 5λ
//���Ի��Ϊ 010000 ����Ҫȥ��ǰ���0
while(sb.charAt(0)=='0'&&sb.length()>1){
	sb.deleteCharAt(0);
}
		return sb.toString();
		
}
	
}
