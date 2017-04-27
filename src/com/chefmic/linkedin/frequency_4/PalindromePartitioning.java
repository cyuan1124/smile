package com.chefmic.linkedin.frequency_4;

import java.util.ArrayList;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s. 

public class PalindromePartitioning {

	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> partition(String s) {
		result.clear();
		ArrayList<String> al = new ArrayList<String>();
		dfs(s, 0, al);
		return result;
	}

	void dfs(String s, int start, ArrayList<String> al) {
		if (start == s.length()) { // �Ѿ�ȫ���й��� Stringȫ������
			result.add((new ArrayList<String>(al))); // ��al����al
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			if (isPalin(s, start, i - 1)) { // ����ֶ��� �Ĵ�start��i-1��һС���ǻ��ľ� ����
				al.add(s.substring(start, i));

				dfs(s, i, al);
				al.remove(al.size() - 1); // ��������Ҫremove�����¼ӵ���� ��Ϊ al�൱�ڻ���
											// �����remove ���forѭ���ͻ��
				// ���string���start���ֶ��������л��Ļ��ظ��� ��������al�൱��һ������
			}
		}
	}

	// �������ǲ��ǻ��� ����ͷ�����бȶ� �����ⷽ���ķ������i j ���ŵ�stringͷβ
	boolean isPalin(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
