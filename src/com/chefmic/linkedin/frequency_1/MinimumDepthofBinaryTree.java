package com.chefmic.linkedin.frequency_1;
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest
//path from the root node down to the nearest leaf node.

import com.chefmic.leetcode.ds.TreeNode;

//       1
//      /
//     2  ������߶�   
public class MinimumDepthofBinaryTree {
	 public int minDepth(TreeNode root) {
	     if(root==null){
	    	 return 0;
	     }
	   int left=minDepth(root.left);//����������С���
	   int right=minDepth(root.right);//����������С���
	   if(left==0){
		   return right+1;
	   }
	   if(right==0){
		   return left+1;
	   }
	   return Math.min(left, right)+1;
		 
	    }
}
