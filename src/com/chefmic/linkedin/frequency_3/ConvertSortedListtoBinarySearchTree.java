package com.chefmic.linkedin.frequency_3;

import com.chefmic.leetcode.ds.TreeNode;
import org.omg.CORBA.Current;

//Given a singly linked list where elements are sorted in ascending order,
//convert it to a height balanced BST.

//"���ж�linkedlist���� �ٸ��ݳ��ȹ������ƽ���bst������Ϊ bst����������ķ��ʴ������sorted ��������������ص� ���ǰ�����������bst����sorted linked list��ֵ����.  1.�ȱ���LL���size Ȼ�� if(size<=0){   return null;  }                                                                                      TreeNode left=sortedListToBSTHelper(size/2); //����������߼� �ȷ������
//TreeNode root=new TreeNode(curr.val);  //��root����һ��LLֵ
//curr=curr.next;  //Ȼ��LL����ù��� ������һ��  //�ٷ����ң�������֤��ֵ������˳��
//TreeNode right=sortedListToBSTHelper(size-1-size/2); //��ΪLL�����Ѿ���һ����
//root.left=left;   root.right=right;"

public class ConvertSortedListtoBinarySearchTree {
	private ListNode curr;

	public TreeNode sortedListToBST(ListNode head) {
		int size;
		curr = head;
		size = getListLength(head);
		return sortedListToBSTHelper(size);

	}

	// �����󳤶�
	private int getListLength(ListNode head) {
		int size = 0;

		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}
	
	private TreeNode sortedListToBSTHelper(int size){
		if(size<=0){
			return null;
		}
		//��ע�� ������� �϶��ǵݹ�������Ծ���inorderһ�� �� ����	
		//�϶�����ִ��  	TreeNode left=sortedListToBSTHelper(size/2);
		//���Ե����϶���1/2 ��0,return null���ϲ�  ��ʱcurr ��head
		//root��curr(head)��ֵ��linkedlisdlist����С��ֵ
		//Ȼ��curr=curr.next
		//��ʵ�ⷽ���ݹ���߼���inorderһ�� �����ң�Ȼ��ÿ����������
        //��ֵ֮�� ����curr=curr.next����һ�� 
		TreeNode left=sortedListToBSTHelper(size/2);
		TreeNode root=new TreeNode(curr.val);
		curr=curr.next;
		                                       //��ΪLL�����Ѿ���һ����
		TreeNode right=sortedListToBSTHelper(size-1-size/2);
		root.left=left;
		root.right=right;
		return root;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
