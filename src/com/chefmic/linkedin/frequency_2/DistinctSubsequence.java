package com.chefmic.linkedin.frequency_2;

//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"    S source

//
//Return 3. 

public class DistinctSubsequence {

    public static void main(String[] args) {                     //source    target
        System.err.println(new DistinctSubsequence().numDistinct("rabbbit", "rabbit"));

    }

    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        //��ʼ״̬
        int[][] nums = new int[S.length() + 1][T.length() + 1];
        //
        for (int i = 0; i <= S.length(); i++) {
            nums[i][0] = 1;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] = nums[i][j] + nums[i - 1][j - 1];
                }
            }

        }
        //
        for (int i = 0; i < nums.length; i++) {
            System.out.println("");
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
        }

        return nums[S.length()][T.length()];


    }
}
