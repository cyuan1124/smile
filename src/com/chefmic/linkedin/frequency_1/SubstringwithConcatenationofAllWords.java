package com.chefmic.linkedin.frequency_1;

import java.util.ArrayList;
import java.util.HashMap;

//You are given a string, S, and a list of words, L, that are all of the same length. 
//Find all starting indices of substring(s) in S that is a concatenation of each word 
//in L exactly once and without any intervening characters.
//
//For example, given:
//S: "  barfoo   the      man"
//L: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter). 

//�ڳ���string���濴����û�ж�string���������Ԫ�� ����оͷ�����ʼ��ĸ���±�
// all starting indices of substring(s) in S that is a concatenation of each word in L exactly once
//Ҫ���ֵ���ÿ���ֶ�ƥ���� 
//without any intervening characters. Ҫ��ʵ���Ĵʵ��в��ܱ������ʸ������� barfoo  foobar �ſ�
//ÿ���ֵ���Ĵʳ���һ��
public class SubstringwithConcatenationofAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int m = L.length;
        int n = L[0].length();// ������ʳ��ȶ���ͬ
        // ��L��ʺͳ��ֵĴ������ŵ�hashmap�� (L��ֵ�������ظ�)
        for (int i = 0; i < m; i++) {
            if (!dict.containsKey(L[i])) {
                dict.put(L[i], 1);
            } else {
                dict.put(L[i], dict.get(L[i]) + 1);
            }
        }
        // ��ΪҪÿ���ʶ�ƥ���� ���� ���С��n*m�Ϳ϶�ƥ�䲻�ϲ��ü����
        for (int i = 0; i <= S.length() - n * m; i++) {
            found.clear();
            int j;
            for (j = 0; j < m; j++) { // j<m һ����m�������ֵ��� ����ÿ����
                int k = i + j * n;// ��ѭ�� ��iλ�� Ȼ�� ��ѭ������j������ ��n�Ǵʳ���
                // ���Ե�ǰ����ƥ��λ�ǳ�String�� k,k+nλ. ƥ�䵱ǰ��j��
                String currSmallWord = S.substring(k, k + n);
                if (!dict.containsKey(currSmallWord)) {
                    break; // �����ǰ�����ûƥ����(��ȡ������ֵ���û��) ֱ��break��ѭ�� i++�����һλ��
                }
                if (!found.containsKey(currSmallWord)) {
                    found.put(currSmallWord, 1);// ������ʷŵ� found ����
                } else {
                    found.put(currSmallWord, found.get(currSmallWord) + 1);
                }
                if (found.get(currSmallWord) > dict.get(currSmallWord)) {
                    break; // ����Ѿ��й�������� ��break ��ѭ��
                }
            }
            // ��Ϊwithout any intervening characters. Ҫ��ʵ���Ĵʵ��в��ܱ������ʸ�������
            // barfoo foobar �ſ�
            // ���Ե��ʶ���ȫ��ʱ�� �ſ��� ��I��һ���ɹ�����ʼ��
            if (j == m) {
                result.add(i);
            }
        }

        return result;
    }
}