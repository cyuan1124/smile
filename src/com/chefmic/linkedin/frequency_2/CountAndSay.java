package com.chefmic.linkedin.frequency_2;
//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string. 

////������n=1ʱ����ַ���1��n=2ʱ�����ϴ��ַ����е���ֵ��������Ϊ�ϴ��ַ�����1��1��
//�������11��n=3ʱ�������ϴ��ַ���11����2��1���������21��
//n=4ʱ�������ϴ��ַ�����21����1��2��1��1���������1211��
// n=5 ʱ������111221 one 1 one 2 two 1 n=6���� 31 2 211  
//6 answer312211 7 answer13112221�������ƣ�д��countAndSay(n)���������ַ�����
public class CountAndSay {
	public  String countAndSay(int n) {
		//��ΪCountAndSayÿ�ζ�����count  countAndSay(n-1)������Ȼ��˵���� ��dp˼�룩
      String lastSay="1"; //ÿ��lastSay��ľ����ϲ�,��ʼlastSay���� n=1ʱ��˵1
     
      while(n>0){
    	  StringBuilder sb=new StringBuilder(); //n���say�ʹ���sb��
    	  char[] oldChars=lastSay.toCharArray();//n-1��say����char����
    	  for(int i=0;i<oldChars.length;i++){ //���� lastsay  ��ʼ count
    		  int count=1; //count�����м���(count)��i
    		  while((i+1)<oldChars.length&&oldChars[i]==oldChars[i+1]){
    			  count++;  //�������м��� oldChars[i]
    			  i++;//��������һλ
    			 } 
    		  //whileѭ�������� �ѵ�ǰcount��oldChars[i] ����sb ��Ϊһ����say
    		  sb.append(String.valueOf(count)+String.valueOf(oldChars[i]));
    	  }
    	 lastSay=sb.toString();
        n--; //������֤����ѭ�������� abs(1-n)=abs(n-1)
      }
      return lastSay;
    }
	
	public static void main(String[] args) {
		for(int i=0;i<=10;i++){
			System.out.println(i+" answer"+ new CountAndSay().countAndSay(i));
		}
	}
}
