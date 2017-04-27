package com.chefmic.linkedin.frequency_3;

//you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
//��һ������������pre order��˳��  ���һ�������� 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// ���Ը�дpre order traverse
//The flattened tree should look like:
//  ȫ�������Ҷ��� ��
//  1
//   \
//    2
//     \
//      3
//       \
//        4
//         \
//          5
//           \
//            6

public class FlattenBinaryTreetoLinkedList {
	// ���lastNode�������ŵ�������ʱ���ϲ��node
	// last.right���Ǳ���Ҫ�ŵĽڵ� �ȷ�˵ ��1��ʱ�� lastnode��null
	// ��2��ʱ��lastnode��1 ��������6��ʱ��lastNode��5
	// ����ÿ�ΰѱ���root����ȥ��ʱ�� lastNode���� root
	private TreeNode lastNode = null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;//�ѱ��ݹ���root�ҹ����ϲ���ҽڵ�
		}
     //��һ������� ����preorder�����ģ�� 
		lastNode = root;
		TreeNode right = root.right;
	//	�ȴ��� lastNode=root Ȼ���ڵݹ����node
		
		flatten(root.left);
		flatten(right); //Ϊʲô����root��right �����Ļ� ���root.rightû��left�ڵ� ���ͻ� ��39��root.right��lastNode��right�� =root��ʵ���ϻ���root��right��
		//Ȼ����ÿ��lastnode���ǽ�����ѭ�����Ǹ�root��left���Ի���ѭ�� ��һֱ��root��right��һͬһ���ڵ��ϼӣ�

	}

	public static void main(String[] args) {
		TreeNode one=new TreeNode(1);
		TreeNode two=new TreeNode(2);
		TreeNode three=new TreeNode(3);
		
		one.left=two;
		one.right=three;
	  (new FlattenBinaryTreetoLinkedList()).flatten(one);
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
