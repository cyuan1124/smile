package com.chefmic.linkedin.frequency_3;

import com.chefmic.leetcode.ds.TreeNode;

//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree. 
//֪��ǰ�����������
/*
 *             5
 *            /  \          
 *           2    7 
 *          / \  / \
 *         1  3 6   8     
 *����     1235678
 *ǰ��    5213768  ����root��ǰ���һ�� val��5 
 *Ȼ�� ȥ������������ 5��position 5��ߵ� ������������5�ұߵĶ���������
 *��ǰ������ 213 ( prestart+1, prestart+position-instart) ������  768( prestart+position-instart+1, preend) ������
 *�ٵݹ�����ұ�����  myBuildTree������������root,���� ��root��5��left��right  
 *���return root
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length != preorder.length) {
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0,
				preorder.length - 1);

	}
	
	private TreeNode myBuildTree(int[] inorder,int instart,int inend,int[] preorder,int prestart,int preend){
		if(instart>inend){
			return null;
		}
	TreeNode root=new TreeNode(preorder[prestart]);
	int position=findPosition(inorder,instart,inend,preorder[prestart]);
	root.left=myBuildTree(inorder, instart, position-1, preorder, prestart+1, prestart+position-instart);
	root.right=myBuildTree(inorder, position+1, inend, preorder, prestart+position-instart+1, preend);
	return root;
	}
  //�� root�� inorder����±� 
	private int findPosition(int[] arr, int start, int end, int key) {
        
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


}
