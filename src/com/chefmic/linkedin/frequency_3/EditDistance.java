package com.chefmic.linkedin.frequency_3;

//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character

//��A�ʱ�λB����Ҫ���ټ�����
//����˼·�ͻ��������ϵ�������һ����  Ԥ������� 
//�����������һ�������� word1��i���� word2 ��j���� ��ô������ matrix[i][j]��ֵ���� word1 iλ��word2 jλ�任�ľ���  
//�Ǳȷ�˵ ������[i-1][j-1]���� word1 i-1λ��word 2 j-1λ�任�Ĵ�����distance��
//��ô Ԥ��������������ʱ��ֻҪreturn ������ֵ�Ϳ��� �����word1ĳλ��word2ĳλ���ַ���һ���� ��ô �Ͳ��ò�����
//     �ȷ�˵a����bbc����3�Ρ� a��b ��һ��b �ټ�һ��b

//  ��ô�������distance[4][4] ����
//0 1 2 3 4 
//1 1 2 3 4 
//2 2 2 3 4 
//3 3 3 3 4 
//4 4 4 4 4 
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return -1;
		}
		// [0][0] ��û������ ����Ҫ��[1][1]��ʼ
		// intialize
		int[][] distance = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			distance[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			distance[0][j] = j;
		}

		// dp
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				// ��һ�����޷�Ҫô��[i-i][j]����Ҫô��[i][j-1]���� �Ǹ��پ�ȡ�Ǹ���Ϊ��minimal
				distance[i][j] = Math.min(distance[i - 1][j],
						distance[i][j - 1]) + 1; // ���char��һ���Ͳ��ñ任��
				distance[i][j] = Math
						.min(distance[i][j],
								distance[i - 1][j - 1]
										+ (word1.charAt(i - 1) == word2
												.charAt(j - 1) ? 0 : 1));

			}
		}
		
		//
		 for (int i = 0; i <distance.length; i++) {
		 System.out.println("");
		 for (int j = 0; j < distance[0].length; j++) {
		 System.out.print(distance[i][j]+" ");
		 }
		}

		
return distance[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		System.err.println( new EditDistance().minDistance("bbbb", "aaaa"));
		
	}
}
 