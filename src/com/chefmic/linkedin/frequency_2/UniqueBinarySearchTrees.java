package com.chefmic.linkedin.frequency_2;

//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

//1~n  Ҫȫ��������bst�� �м��ֿ��ܵ�����
//��dfs��˼��  ��rootΪ1ʱ�� rootΪ2ʱ�� rootΪ3ʱ��ѭ�� һֱ��n �����for
//Ȼ��rootΪ1ʱ�� ��߲��ܷ� �ұ߷�2~n   rootΪ2ʱ��  ��߷�1 �ұ߷�3��n
//��֮ �� rootΪ iʱ�� ��߷�1��i-1  �ұ߷�1+1��n�������������dfs
//ѭ������1����

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numTrees(1, n);
    }

    int numTrees(int start, int end) {
        if (start >= end) {
            return 1;  //ֻ��һ�ֿ���  �ս�����
        }
        int totalNum = 0;
        for (int i = start; i <= end; i++) {
            totalNum = totalNum + numTrees(start, i - 1) * numTrees(i + 1, end);
        }
        return totalNum;

    }
}
