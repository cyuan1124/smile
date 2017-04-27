package com.chefmic.linkedin.frequency_2;

import java.util.HashMap;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, return the emtpy string "".
//
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
//��source�������ܰ���target�����ַ� ����С���Ƕ�(�Ӽ�)

//1.�Ȱ�target������Щchar ���м��� �浽hashmap��
//2.Ȼ���ٽ�һ��minWindow��hashmap�����Source -window sliding����������Щchar ��������Ȼ����target��ľ�continue��Ҫ���ˣ�
//3.Ȼ��forѭ������Source, window��leftbound����lb rightbound����forѭ����i��
//4.���charAt(i) ����t���continue �ڵĻ��ʹ���minWindow��hashmap
//5.��¼������window���char������������Ƿ��Ѿ����� (���ұ߸���)
//6.������� tCount == T.length() window ���char�����������඼���� target�� ���Կ�ʼ
//7.ѹ��window�� minwindow����ʱlbΪ0 7.1a���S.charAt(lb) ����target���char ֱ��lb++ ��
//7.1b���S.charAt(lb) ��minWindow�����������target������ Ҳlb++ ��minwindow���charҪ-1��Ȼ��continue������forѭ����
//8.���7.1a�Ѿ�ѭ�����˵����ֲ���7.1b��ִ������ ��break�����forѭ�� ��ʱ�Ѿ��ҵ���Ȼ��minWindow = S.substring(leftBound, i + 1); 
//(�ǵü��window ���ȺϷ��� ) Ȼ�������null�Ļ�return ""


public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0) {
			return S;
		}
		if (T == null || T.length() == 0) {
			return "";
		}
		// ��target�����char ������ ���� ���ŵ�hashmap��
		HashMap<Character, Integer> charInTCounter = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			Character c = T.charAt(i);
			if (charInTCounter.containsKey(c)) {
				charInTCounter.put(c, charInTCounter.get(c) + 1);
			} else {
				charInTCounter.put(c, 1);
			}
		}

		// �þ��� window sliding������ window����߾���leftBound �ұ߾���i
		// ���minWindowCounter�Ǵ� ������window sliding���window��char���涼���� �м���
		HashMap<Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
		String minWindow = null;
		int tCount = 0;
		int leftBound = 0;
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			// ���s�ĵ�i��char�� target��û�� ��������һ��char
			if (!charInTCounter.containsKey(c)) {
				continue;
			}
			if (minWindowCounter.containsKey(c)) {
				minWindowCounter.put(c, minWindowCounter.get(c) + 1);
			} else {
				minWindowCounter.put(c, 1);
			}
			// �ȷ�˵ T��ccc Ȼ��s�� cbcccdd Ȼ���һ��c��ʱ�� tCount++ �ڶ���t��ʱ��tCount
			// ������Tʱ��Ҳ��tCount++ ���� ���ȫ����������� tCountӦ�õ��� target��length
			if (minWindowCounter.get(c) <= charInTCounter.get(c)) {
				tCount++;
			}

			// ˫ָ�룬��̬ά��һ�����䡣βָ�벻������ɨ����ɨ����һ�����ڰ���������T���ַ���
			// Ȼ��������ͷָ�룬ֱ������������Ϊֹ������¼���п��ܵ�����д�����С��

			// ������� target�����char��source���涼���� (!ע�� ��ʱ��һ��ɨ������source��)
			if (tCount == T.length()) {
				
				// ��ʼleftBound=0
				// �����ǰlb���ڵ��Ǹ�char����target�����ĸ ֱ������ ����ѭ��
				while (leftBound < S.length()) {
					Character ch = S.charAt(leftBound);
					if (!charInTCounter.containsKey(ch)) {
						leftBound++;
						continue;
					}

					// �����ch( ch=S.charAt(leftBound);)��ʱ��ch�Ѿ���target��Ҫ�������������
					if (minWindowCounter.get(ch) > charInTCounter.get(ch)) {
						minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
						leftBound++;// ��ô��ǰ��leftbound++�Ϳ��Ա�����
						continue;
					}
					// ������2��if�����Ϊ����С���window��
					// ����Ѿ�������������
					break;// forѭ�� �Ѿ��н����
				}
				// ���leftbound ��rightbound(i)�ĺϷ���
				if (minWindow == null || i - leftBound + 1 < minWindow.length()) {
					minWindow = S.substring(leftBound, i + 1);
				}
			}
		}

		if (minWindow == null) {
			return "";
		}
		return minWindow;

	}
}
