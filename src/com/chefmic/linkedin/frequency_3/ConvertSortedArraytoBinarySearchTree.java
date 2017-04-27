package com.chefmic.linkedin.frequency_3;

import com.chefmic.leetcode.ds.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		return helper(num, 0, num.length - 1);
	}

	private TreeNode helper(int[] num, int low, int high) {

		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, low, mid - 1);
		root.right = helper(num, mid + 1, high);
		return root;
	}
}