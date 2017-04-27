package com.chefmic.linkedin.frequency_3;

import java.util.ArrayList;
//dfs---ѭ���ӵݹ�  ���� subsets 
//�;����㷨��ģ����� 

public class LetterCombinationsofaPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
		String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		ArrayList<String> result = new ArrayList<String>(); // ���sb�൱��һ������
		if(digits==null||digits.length()==0){
			return result;
		}
		dfs(result, digits.length(), dict, digits, new StringBuffer());
		return result;
	}

	void dfs(ArrayList<String> result, int remain, String[] dict,
			String digits, StringBuffer sb) {
		// ���趨����recursion������
		if (remain == 0) { // ˵������digits��ÿ��һ�����ֶ�������
			result.add(sb.toString());
			return;
		}
		// ������õ��Ǳ��εݹ�����ֶ�Ӧ��string �ȷ�˵ 234
		// ���Ȼ�ȡ2 Ȼ��forѭ����2��ÿ����Ӧ��char �ŵ�sb�� Ȼ���ٰ�sb ��34 �����ݹ鷽���� �����͵��ڴ��� a 34 b 34
		// c 34 ���¸��ݹ鷽��
		// Ȼ��a 34 �ٵݹ�ѭ�� ad4 ae4 af4 bd4 be4 bf4 c��������Ȼ���ٵݹ鵽��һ�� ֱ�������������
		// add��arraylist��
		// ��Ȼ ��Ϊ��dfs ����˵��ѭ���ݹ鵽���������ѭ���ڶ���
		String s = dict[digits.charAt(0) - '0']; // char������תint ��Ϊ�ֵ�����±�
		for (int i = 0; i < s.length(); i++) {
			sb = sb.append(s.charAt(i));
			dfs(result, remain - 1, dict, digits.substring(1), sb);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

}
