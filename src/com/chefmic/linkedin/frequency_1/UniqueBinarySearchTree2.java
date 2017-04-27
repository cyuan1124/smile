package com.chefmic.linkedin.frequency_1;

import com.chefmic.leetcode.ds.TreeNode;

import java.util.ArrayList;

//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
// 1         3     3      2      1
//  \       /     /      / \      \
//   3     2     1      1   3      2
//  /     /       \                 \
// 2     1         2                 3

public class UniqueBinarySearchTree2 {
    public ArrayList<TreeNode> generateTrees(int n) {

        return numTrees(0, n - 1);
    }

    // dfs
    private ArrayList<TreeNode> numTrees(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftChild = numTrees(start, i - 1);
            ArrayList<TreeNode> rightChild = numTrees(i + 1, end);
            for (int j = 0; j < leftChild.size(); j++) {
                for (int k = 0; k < rightChild.size(); k++) {
                    TreeNode root = new TreeNode(i + 1);// that store values
                    root.left = leftChild.get(j);
                    root.right = rightChild.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
