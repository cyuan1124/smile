package com.chefmic.linkedin.frequency_2;

import java.util.LinkedList;
import java.util.Queue;

//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?
//
//Note:
//
//You may only use constant extra space.
//�ڶ��⣺��һ�������������� ���� ��ͨ�Ķ����� 
//������ÿһ��Ľڵ�ָ���ұߵĽڵ㡣 
////eg   1 -> NULL
//      /  \
//     2 -> 3 -> NULL
//    / \    \
//   4-> 5 -> 7 -> NULL


//�����׵�˼· ���� level order
//����level order ���ԣ� while (!queue.isEmpty()) {   int size = queue.size();����ǰqueue�� ��������ǰ���Ԫ�ظ����õ���forѭ����
//����poll��ǰ���һ��node Ȼ��ѵ�ǰpoll���������Ҷ��ӣ�Ȼ�� �����ʱ���forѭ����i<size-1�� 
//˵��current���node���滹�б��������node ����  current.next = queue.peek()
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
           
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();  //��ʾ��ǰlevel��size
			for (int i = 0; i < size; i++) {
				TreeLinkNode current = queue.poll();
				if (current.left != null) {//�����Ҷ��� ����queue
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
				if (i < size - 1) {//��forѭ���� ���ڱ�������queue�����node Ȼ�� current node��û�����һ����ʱ��
					                //current.nextָ��queue  ����һ��  queue.peek();
					current.next = queue.peek();
				}
			}
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}