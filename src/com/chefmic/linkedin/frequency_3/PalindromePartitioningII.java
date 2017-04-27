package com.chefmic.linkedin.frequency_3;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
//���Ҫ��������ÿ���ֶ��ǻ��� ��С���

public class PalindromePartitioningII {
	// �����㷨 2 sequence dpģ��
	// ����PalindromePartitioning ��һ��2sequence dp Ԥ����
	//�� isPalindrome�� ��� [x][y]��ture ��ʾ String s ��charAt(x) �� charAt(y)�ǻ���(ǰ�պ��)
    //��Ϊ ÿ����ĸ�����Լ��Ļ��� ���� ���2sequence dp��base case���� [i][i]����true
	//Ȼ�� ���char At i=i+1 ��ô aa bbҲ�ǻ��� Ȼ�� isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)); 
	// Ȼ�� /start��start+length��һ���ǲ��ǻ��ģ���ǰ�պ�գ�
	// ��� start+1��start+length-1 �ǻ���
	//���� s.charAt(start)=s.charAt(start+length) ��ô start,start+lengthҲ�ǻ���
	//eg�� baab�� ���aa�ǻ�����ô�� b=b ����baabҲ�ǻ���
	//���dp�ǴӶԽ����м���������ɢ
	//Ȼ�����ھ�����������min cut ��һ��1άdp  cut[i] ��ʾ string��iλλ���гɻ��ĵ���С�и���+1
//	for (int j = 1; j <= i; j++) {
//		 //���string��i-jλ��i-1λ�ǻ���      eg i=5 j=2 ��ô����String(3,4)��palindrom
//			if (isPalindrome[i - j][i - 1]
//				//���� cut[3]�����гɻ��ĵ� ��ô��ʾcut[i]Ҳ���гɻ���
//					&& cut[i - j] != Integer.MAX_VALUE) {
//				cut[i] = Math.min(cut[i], cut[i - j] + 1);
	
	
//     a     a      b   //�����ֻ������������������ġ���Ϊ[0],[1] ���� aa  [1][0]ɶ��������
//  a true  true  false 
//  a false true  false 
//  b false false true 


	private boolean[][] getIsPalindrome(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		// ��ʼdp
		//�� isPalindrome�� ��� [x][y]��ture ��ʾ String s ��charAt(x) �� charAt(y)�ǻ��� ǰ���Ǳ�����[][]
		// ÿ����ĸ�������Լ��Ļ���
		for (int i = 0; i < s.length(); i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			// ���s.charAt(i) == s.charAt(i + 1) eg aa bb cc
			//��ô [0][1],[2][3],[4][5] Ҳ���ǻ���
			isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

		}

		for (int length = 2; length < s.length(); length++) {
			// startΪ���Ŀ�ʼ��char lengthΪ���ĳ��� 
			for (int start = 0; start + length < s.length(); start++) {
	           //start��start+length��һ���ǲ��ǻ��ģ���ǰ�պ�գ�
				// ��� start+1��start+length-1 �ǻ���
				//���� s.charAt(start)=s.charAt(start+length) ��ô start,start+lengthҲ�ǻ���
				//eg�� baab�� ���aa�ǻ�����ô�� b=b ����baabҲ�ǻ���
				//���dp�ǴӶԽ����м���������ɢ
				isPalindrome[start][start + length] = isPalindrome[start + 1][start
						+ length - 1]
						&& s.charAt(start) == s.charAt(start + length);
			}
		}

		for (int i = 0; i <isPalindrome.length; i++) {
			 System.out.println("");
			 for (int j = 0; j < isPalindrome[0].length; j++) {
			 System.out.print(isPalindrome[i][j]+" ");
			 }
			}

		return isPalindrome;

	}

	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] cut = new int[s.length() + 1];
		boolean[][] isPalindrome = getIsPalindrome(s);
		cut[0] = 0;// һάdp cut[i]��ʾ ��S��charAt(i)λʱ�� ���ټ����ܿ���ȫ�ǻ��ĵ�
		for (int i = 1; i <= s.length(); i++) {
			cut[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
			 //���string��i-jλ��i-1λ�ǻ���      eg i=5 j=2 ��ô����String(3,4)��palindrom
				if (isPalindrome[i - j][i - 1]
					//���� cut[3]�����гɻ��ĵ� ��ô��ʾcut[i]Ҳ���гɻ���
						&& cut[i - j] != Integer.MAX_VALUE) {
					cut[i] = Math.min(cut[i], cut[i - j] + 1);
				}
			}
		}
		return cut[s.length()] - 1;
	}
public static void main(String[] args) {
	new PalindromePartitioningII().minCut("aab");
}
}
