package com.chefmic.linkedin.frequency_2;

//    1           
//   / \
//  2   2
// / \ / \
//3  4 4  3  true ���������ұߺ������������һ�� mirror symmetric  ������ͬ���� 
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
// false ��Ȼ��������һ�� ���ǲ���mirror of itself

import com.chefmic.leetcode.ds.TreeNode;

//���һ�����Ƿ� mirror symeetric
//devide and concur��˼· bfs
//��Ϊroot�϶�ֻ��1�� 
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
return isSymmetric(root.left,root.right);
	}

	public boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left==null&&right==null){
			return true;
		}else if(left!=null&&right!=null){
			// ���������ұߺ������������һ�� mirror symmetric  ������ͬ���� 
	return left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right, right.left);
		}else{
			return false;
		}
	}
}
