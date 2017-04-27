package com.chefmic.linkedin.frequency_3;

import com.chefmic.leetcode.ds.TreeNode;

//����DFSģ��  dfs�Ľ���������rootû���ӽڵ㣨root��Ҷ�ӣ�
//Ȼ�� ����дforѭ�� ��Ϊ�Ƕ����� ֻҪ�ֱ�ݹ������ӽڵ㵱��root���ɡ� 
//�ǵ� (��������ݹ鷽������ô������ ��Ϊ ֻ��һ��onePath��Ϊ����path�Ļ��� 
//		���Եݹ鷽��������ʱ��Ҫ onePath.remove(onePath.size()-1);
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		sum = sum - root.val;
		// �������� �� ��Ҷ�ӽڵ�ʱ��sum==0
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				return true;
			}
		}
     if(hasPathSum(root.left,sum)){return true;}
     if( hasPathSum(root.right, sum)){return true;}
     return false; 
	}
}
