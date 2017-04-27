package com.chefmic.linkedin.frequency_3;

//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5. 

//����һ������������һ��ֵx�������������ʹ�����б�xС��node�������б�x���node��ǰ�档ͬʱע�Ᵽ�ֽڵ�ԭ�е����λ�ù�ϵ
public class PartitionList {
//��ָ�� һ��ʼ left leftDM right rightDM ���Ǵ�dummy Ȼ��
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode leftDummy = new ListNode(0);
		ListNode rightDummy = new ListNode(0);
		ListNode left = leftDummy;
		ListNode right = rightDummy; //��ʱ�� leftDummy�� left/ rightDummy��right��ͬһ������ 
		//Ȼ�󵱵�һ�ν�whileѭ����ʱ��ִ��25����28�У���ʱ���ǵ�.next�����³ɵ�ʱ��head
		//Ȼ��left/right���reference���ĳ�head��,��ô�Ժ��ٶ�left.next/right.next�Ķ���Ldummy/Rdummy�޹���
		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = head;  //������xС�Ķ�������left��,���ұ�����˳��
			} else {
				right.next = head; // ��x��Ķ�������right�� ,���ұ�����˳��
				right = head;
			}
			head = head.next;
		}
		
// 
//leftDym.next     left
//        |         |
//		  1 -> 2 -> 2 
//rightDym.next     right
//         |         | 
//		   4 -> 3 -> 5
		
		right.next = null; 
		left.next = rightDummy.next;
		return leftDummy.next;
	}
}
