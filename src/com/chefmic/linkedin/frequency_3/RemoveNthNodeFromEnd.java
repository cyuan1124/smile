package com.chefmic.linkedin.frequency_3;

//ɾ��LL������N�� Node
//   Given linked list: 1->2->3->4->5, and n = 2.
// result                1->2->3->5.
public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// ҪŪ��dummy head ������Ҫɾ��������ͷ�ڵ�����
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < n; i++) {
			if (fast.next == null) { 
				//��ע�� fast.next==null ˵��ʲô ��Ϊn��Ŀ������valid �����ƶ�n��
				//��fast.next==null˵��fast�Ѿ������ n  ����linkedlist������ ����Ҫɾ�ľ���ͷ�ڵ㡣
				return head.next;
			}
			fast = fast.next;
		}
	 
		while (fast.next != null) {
			 
			fast = fast.next;
			slow = slow.next;
		}

	slow.next = slow.next.next;   
		return dummyHead.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}