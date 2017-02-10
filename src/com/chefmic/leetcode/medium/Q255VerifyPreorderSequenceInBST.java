package com.chefmic.leetcode.medium;

/**
 * Created by cyuan on 2/9/17.
 */
public class Q255VerifyPreorderSequenceInBST {

    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1);
    }

    private boolean verify(int[] preorder, int start, int end) {
        if (start > end) return false;
        int root = preorder[start];
        int left = start;
        while (left < end && preorder[left + 1] < root) {
            left++;
        }
        int right = left + 1;
        while (right <= end) {
            if (preorder[right++] < root) return false;
        }
        return verify(preorder, start + 1, left) && verify(preorder, left + 1, end);
    }

}
