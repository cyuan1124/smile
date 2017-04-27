package com.chefmic.linkedin.frequency_2;

import java.util.ArrayList;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//For example:
//Given the below binary tree and sum = 22,
//
//             5
//            / \
//           4   8
//          /   / \
//         11  13  4
//        /  \    / \
//       7    2  5   1
//��������root��Ҷ�� �ĵ�����·�� where path sum��ָ��ֵ
//�þ����㷨ģ�� ��

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> onePath = new ArrayList<Integer>();
        find_sum(result,onePath,root,sum);
	     return result;
	  }

	private void find_sum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> onePath, TreeNode root, int sum){
	if(root==null){
		return;
	}	
	sum=sum-root.val;
	//������������ʾ�Ѿ���root�ڵ�
	if(root.left==null&&root.right==null){
		if(sum==0){ //sum�����ֵ���ÿ���,path ��sum������sum 
			
			onePath.add(root.val);
			result.add(new ArrayList<Integer>(onePath));
			onePath.remove(onePath.size()-1);
		}
		return; //�ҵ�path�� ���dfs��֦�����굽���� ����
	}
	
	onePath.add(root.val);
	//����ûдforѭ�� ȡ����֮���� ��������
	find_sum(result, onePath, root.left, sum);
	find_sum(result, onePath, root.right, sum);
	onePath.remove(onePath.size()-1);//����μӵ�root��ɾ�� ��ΪonePath���arrayList��Ψһ��
	//�ȷ�˵����dfs��Խ��Խ���� onePath�����intҲԽ��Խ�ࡣֱ����Ҷ�ӽڵ� ����ǶԵ�ֵ��result
	//�������ŵݹ鷽�������ķ��� ,ÿһ�㶼���Լ��ӵ��Ǹ�ֵɾ������󷵻ص��ò��ʱ�� ��Щ�ɵݹ��
	//�ӵ�������ɾ���ˡ� �ȷ�˵find_sum(result, onePath, root.left, sum); Ȼ�� one Path��intԽ��Խ��
	//���ǵݹ鶼���ص�ʱ�� �ֶ�ɾ����
	//���� find_sum(result, onePath, root.right, sum); Ҳ��������λ�ÿ�ʼ��
	
	
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
