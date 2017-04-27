package com.chefmic.linkedin.frequency_2;

import java.awt.List;

import javax.annotation.PostConstruct;

//Reverse a linked list from position m to n. Do it |in-place| and |in one-pass.|
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//  //��2��4֮���node�������� 
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 �� m �� n �� length of list. 
//  ������Ҫ���ľ��� �ڷ�ת�����Ƕ� mn�󣬳�Ϊ�� 1 n m end
//�� 1-n�� m-end ������ ����ؼ��ġ� �ȷ�˵ 1->2->3->4->5 ��ת 2��4 ��Ϊ 
// 1->4->3->2->5  ��ô 1->4�����Ӻ�2->5������ ��ЩҪ��� ���Ծ�Ҫ��¼
//��һ�����һ���ڵ�(��m-1��node)����ת���׽ڵ�(��m��node)����ת����β�ڵ�(��׼��ת����return��newnode)��
//�����ε�һ���ڵ�(��׼��ת����next.next)

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m >= n) {
			return null;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		head = dummy;
		// ��� �Ƿ�û��m����ͽ�����
		for (int i = 1; i < m; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		// forѭ�������� head��m��֮ǰ���Ǹ�node
		ListNode premNode = head;
		ListNode mNode = head.next; // m �ڵ㱾��
		ListNode nNode = mNode;
		ListNode postnNode = mNode.next;// n֮����Ǹ�node
		// ��ʼ����m n��
		for (int i = m; i < n; i++) {
			if (postnNode == null) {
				return null;// �����û��n LL�ͽ����� ��ô����null
			}
			// ������linkedlist��ת ����ͬ����postnNode ��nNode������һ��ѭ���ƺ�һ��
			ListNode temp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = temp;
		}

		
		mNode.next=postnNode;//2->5������
				premNode.next=nNode;//1->4������
				return dummy.next;
				
						
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

// δ��ɵĴ���2
// if (head == null||m>=n) {
// return null;
// }
// ListNode dummy =new ListNode(-1);
// dummy.next=head;
// ListNode preBegin=dummy;// ���preBegin���Ǳ�ǵ�һ�����һ���ڵ�
// int currentIndex=1;
// while(preBegin!=null&&currentIndex<m){
// preBegin=preBegin.next; //��Ϊһ��ʼ����dummy ��.next=head��
// currentIndex++; //���Ե�һ��ѭ�������1
// //ѭ��m-1��--preBegin��m-1
// }
// ListNode reverseEnd=preBegin.next; //��ת���׽ڵ�(��m��node)
// ListNode reHead=null;//��ת���ͷ
// ListNode cur=preBegin.next;
//
// //http://blog.csdn.net/fightforyourdream/article/details/17332977
// //�ǵ÷��𰸺�������
//

// �д�Ĵ���1
// public ListNode reverseBetween(ListNode head, int m, int n) {
// if (head == null) {
// return null;
// }
// ListNode DH = new ListNode(0);
// DH.next = head;
// ListNode prev1 = null;
// while (m > 1) {
// prev1 = head;
// head = head.next;
// m--;
// n--;
// }
//
// ListNode newHead = null;
// ListNode reverseEnd = head;
//
// ListNode unreversed = null;
// while (n > 1) {
// ListNode next = head.next;
// head.next = newHead;
//
//
// newHead = head;
// head = next;
// n--;
// unreversed=next;
// }
// if (prev1 != null)
// prev1.next = newHead;
//
// if (reverseEnd != null) {
// reverseEnd.next = unreversed;
// }
//
// return DH.next;
//
// }
// }