package com.chefmic.linkedin.frequency_2;
//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false. 

 //          e      d   f  
//    true false false false 
//  a true false false false 
//  b true true true false 
//  c false false true true 



//�� s3�Ƿ�����s1 s2�����ǲ�����˳������
//�����㷨 Ԥ���� 2 sequence DPģ�� boolean[i][j] ���ǵ�һ��string����i��charʱ���Ƿ� ��2��string��j��charʱ���Ƿ�interleaving ��
//��󷵻� boolean[s1.length()][s2.length()];
public class InterleavingString {
public boolean isInterleave(String s1, String s2, String s3) {
  //���
	  if (s1 == null || s2 == null || s3 == null) {
          return false;
      }
      if (s1.length() + s2.length() != s3.length()) {
          return false;
      }
//��ʼ������
      boolean[][] interleave = new boolean[s1.length() + 1][s2.length() + 1];
      interleave[0][0] = true;
     
      //��ʼ�� ������� �൱��basecase
     for(int i=1;i<=s1.length();i++){
    	 interleave[i][0]=s1.subSequence(0, i).equals(s3.subSequence(0, i));
    	 
     }
      //��ʼ�������ϱ� �൱��basecase

for(int i=1;i<s2.length();i++){
	interleave[0][i]=s2.substring(0,i).equals(s3.subSequence(0, i));
}
     //dp����
    for(int i=1;i<=s1.length();i++){
    	for(int j=1;j<=s2.length();j++){
    		interleave[i][j]=false;
    		
    // ���� boolean[i][j] ��s3�ĵ�char[i+j-1] λ�Ƿ��ǵ�һ��string����i��charʱ��� ��2��string��j��charʱ����ϵ�interleaving 		
    		//�����ǰ�ַ���� 
    		if(s1.charAt(i-1)==s3.charAt(i+j-1)){
    			                      //���ж�ǰ���ַ��಻��� �����һ����� �ټ��ϱ�λҲ��� ��ʾ�Ϳ���һ�����
    			interleave[i][j]=interleave[i][j]||interleave[i-1][j];
    		    }
    	if(s2.charAt(j-1)==s3.charAt(i+j-1)){
    		interleave[i][j]=interleave[i][j]||interleave[i][j-1];
    	}
    		
    		}
    }
    for (int i = 0; i <interleave.length; i++) {
		 System.out.println("");
		 for (int j = 0; j < interleave[0].length; j++) {
		 System.out.print(interleave[i][j]+" ");
		 }
		}
	return interleave[s1.length()][s2.length()];
}

public static void main(String[] args) {
	new InterleavingString().isInterleave("abc", "edf", "abedcf");}
}
