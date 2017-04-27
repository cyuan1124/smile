package com.chefmic.linkedin.frequency_2;

import com.chefmic.leetcode.ds.TreeNode;

//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.����˵ֻ�û�val������

public class RecoverBinarySearchTree {

    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        //traverse and get two elements

        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    //in-order traverse
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (firstElement == null && root.val < lastElement.val) {//����ݹ��root�� ����������ϸ�node�ȿ����򲻴���sort
            firstElement = lastElement;  //��һ�����Ƶ�sort��node
        }
        if (firstElement != null && root.val < lastElement.val) {//����ݹ��root�� ����������ϸ�node�ȿ����򲻴���sort
            secondElement = root;  //�ڶ��δ�����Ƶ�sort��node
        }
        lastElement = root; // ÿ�������������һ��node
        traverse(root.right);
    }


}
