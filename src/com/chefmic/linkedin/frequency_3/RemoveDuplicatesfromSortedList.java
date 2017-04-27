
package com.chefmic.linkedin.frequency_3;
//Given a sorted linked list, delete all duplicates such that each element appear only once. 
//˫ָ�� ������ ���ÿ�غ϶���һ�� ����ֻ���ڿ������ȵ�ʱ��ź���һλ
//Ȼ��ѿ��val���ƹ��� Ȼ�󵱿���ߵ��׵�ʱ������ֱ�� ��.next==null


public class RemoveDuplicatesfromSortedList {
	// ��Ϊ��sorted ����ֻҪǰ��ȾͿ���
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		//˫ָ��
		ListNode prev = head;
		ListNode current = head.next;
		// ���ظ�
		while (current != null) {
			if (prev.val != current.val) {
				prev = prev.next;
				prev.val = current.val;
			}
			current = current.next;
		}
		prev.next = null;
		return head;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
