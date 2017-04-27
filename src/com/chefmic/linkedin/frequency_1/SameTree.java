package com.chefmic.linkedin.frequency_1;

import com.chefmic.leetcode.ds.TreeNode;

//ûɶ��˵�� �����һ�� ע��2�����ǿ���Ҳ����true
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null && p != null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }


        return true;
    }
}
