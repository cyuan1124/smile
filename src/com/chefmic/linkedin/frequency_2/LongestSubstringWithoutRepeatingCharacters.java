package com.chefmic.linkedin.frequency_2;

import java.util.HashSet;

//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
//For "bbbbb" the longest substring is "b", with the length of 1.
//���������ڡ����������е�����maximum subarray�Ļ������ڡ� �ȷ�˵ abcabccc �����ұ�ɨ�赽abca��ʱ�����
//�ѵ�һ��aɾ���õ�bca Ȼ��"����"�������һ�����ÿ���ӵ�һ����char��ʱ��
//��߼�������ظ��ģ���hashmap��Ȼ�����û�ظ����������� ���ظ� �Ļ� ������ӵ�һ����
//���������ظ�char����ӵ��� �ں�����������м�¼����

//hashset��¼�Ѿ����ڵ�char    ���� ��������������ά��
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
 if(s==null||s.length()==0){
	 return 0;
 }
 HashSet<Character> set=new HashSet<Character>();
 int leftBound=0;
 int max=0;
 for(int i=0;i<s.length();i++){
	 //�����Ҳ�ɨ���ظ��ַ��� ��if��
	 if(set.contains(s.charAt(i))){
		 //���whileѭ��Ϊ��Ҫ��ôд
		 //eg:����������䡡Ȼ�󴰿�ɨ�����ʱ��
		 //�ð�abc����hashset��ɾ��
		 while(leftBound<i&&s.charAt(leftBound)!=s.charAt(i)){
			 set.remove(s.charAt(leftBound));
			 leftBound++;  //while ����ɾabc
		 }
		 leftBound++; //��Ϊd������Ҫ�ӵ� ����Ҳ����ɾ���ټ��ˣ� //left��2��3
		 
	 }else{//û���ظ���
		 set.add(s.charAt(i));
		 max=Math.max(max,i-leftBound+1);//i-leftBound+1  ��ǰ���ڳ���
	 }
 }
 
 return max;
 
	}
}
