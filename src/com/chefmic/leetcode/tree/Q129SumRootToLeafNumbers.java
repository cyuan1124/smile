package com.chefmic.leetcode.tree;

import com.chefmic.leetcode.ds.TreeNode;

/**
 * Created by cyuan on 1/2/17.
 */
public class Q129SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;

        Q129SumRootToLeafNumbers tester = new Q129SumRootToLeafNumbers();
        System.out.println(tester.sumNumbers(t1));

        int[] arr = {1, 2, 3, 4, 5};
        int i = 1;
        System.out.println(arr[++i] + " " + i);
    }

    public int sumNumbers(TreeNode root) {
        return calculate(root, 0, 0);
    }

    private int calculate(TreeNode node, int accu, int sum) {
        if (node == null) return sum;
        accu = accu * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum + accu;
        } else {
            return calculate(node.left, accu, sum) + calculate(node.right, accu, sum);
        }
    }
}
