package com.chefmic.linkedin.frequency_3;
 

public class RemoveDuplicatesfromSortedList2 {
//	1��dummyhead.next=4ָ�� pre(���ȥ���ص������ͷ�ڵ�)  realpre curr next   3��node�����ң�  �������÷Ǳ�̵�˼�뿼�����⡣
//			ֻ����ȫΨһ��node���ܱ�������ô ���node �����費����ǰ���������Ҫ��ǰ��node����һ���ſ�������Ψһ��pre curr next����ƽ�Ƽ�飩
//			(��һ�αȽϵĳ�ʼ״̬����dummyhead,head,head.next)��
//			��ô���ǿ����ò���ƽ�Ƶ�node�������Щnode��eligibal�ġ���ѭ����pre.next=null;��ֹ����������������ټ��β�͡�   �ڷ���dummyhead.next
	

	
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		// ����Ƿ�ֻ��һ���ڵ�����
		if (head.next == null) {
			return head;
		}
		//ps �㲻�� pre curr next ����ָ����ô  ��ôdummy head����ȷ�÷����� dh��next=head Ȼ��dh��pre ������ head��curr���� head��next��next������ 
		// 4 pointers  dummyHeadҪ����һ�� �ͺ��治���ظ��ĵ�ֵ Ȼ����pre curr nextϵͳ�����pre  ԭ��head���� curr
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next=head;
		ListNode pre = dummyHead;
	    ListNode realpre=dummyHead;
		ListNode curr = pre.next; //����head
		ListNode next = curr.next; //head.next
 
	

		while (next != null) {
			if (curr.val != realpre.val && curr.val != next.val) {
				// �ܽ����˵�� curr��unique��
				pre.next = curr;
				pre=pre.next;
				
			}
		
	        realpre=realpre.next;
			curr = curr.next;
			next = next.next;
			
		}
		//�����Ƿ�ֹpre���滹������������
		pre.next=null;
		// �������һλ
		if (curr.val != realpre.val) {
			pre.next = curr;
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(3);
//	ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(5);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
//    	n3.next = n4;
//		n4.next = n5;
//	n5.next = n6;

		print(head);
		ListNode h = deleteDuplicates(head);
		System.out.println();
		print(h);
	}

	static void print(ListNode a) {
		while (a != null) {
			System.out.print(a.val);
			a = a.next;
		}

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


//����2 ����������ж�
// public class RemoveDuplicatesfromSortedList2 {
// public ListNode deleteDuplicates(ListNode head) {
// if(head==null){
// return null;
// }
// ListNode dummyHead=new ListNode(0);
// //3 pointers
// dummyHead.next=head;
// ListNode pre=dummyHead;
// ListNode curr=pre.next;
// ListNode next=curr.next;
//
// boolean duplicate=false;
// while(true){
// if(next==null){
// break;
// }
// if(curr.val!=next.val){
// if(duplicate){
// pre.next=next;
// duplicate=false;
// }else{
// pre=curr;
// }
// curr=next;
// next=next.next;
//
// } else if(curr.val==next.val){
// duplicate=true;
// next=next.next;
// }
// }
// // ɨβ���������������{1,1}�������������ж�һ��
// if(duplicate){
// pre.next=next;
// }
// return dummyHead.next;
// }
