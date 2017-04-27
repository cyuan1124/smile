package com.chefmic.linkedin.frequency_2;
// Given a list, rotate the list to the right by k places, where k is
// non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.
// rotate һ��LL nλ. ����˵n�� ÿ��rotateһλ
public class RotateList {
// ���ȴ�head��ʼ�ܣ�ֱ�����һ���ڵ㣬��ʱ���Եó�������len��Ȼ��βָ��ָ��ͷָ�룬
	//������Ȧ��������������ǰ��len �C k%len��������Ͽ�������Ҫ��Ľ���ˡ�
//
	
	// �ȷ�˵1-2-3-4 ��ת2�γ�Ϊ 3-4-1-2
//   1--2--3--4  �ҵ�β�� ��β������ͷ�γɻ�
//   |--------|
//Ȼ�����ҵ�2λ�� ���Ǹ�   rotateHead =2.next(3) Ȼ�� ==null
//���return rotate
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int length = getLength(head);
		// ��֤��n�ĺϷ���
		n = n % length;
		 ListNode back = head;  
	        ListNode front = head;  
	        ListNode end = head;  
	          
	        // �Ȱ������Ϊѭ������  
	        while(front.next != null){  
	            front = front.next;  
	        }  
	        end = front;        // ��¼ԭβ�ڵ�  eg 4
	        front.next = head;  // �γɻ�  
	        front = head;       // ��ԭfrontָ��   eg1
	          
	        // ʹ��front��backǰ��n������  
	        for(int i=0; i<n; i++){  
	            front = front.next;   //��ʱ front�ᵽ��ת���ͷ eg 3
	        }  
	          
	        // ˫ָ��ͬ���ƶ�  
	        while(front != end){  
	            front = front.next;    //�Ƶ�front=end ��ʱ 
	            back = back.next;  //���סback һ��ʼ��0 ,�� front=endʱ�� back��2
	        }  
	          
	        ListNode rotateHead = back.next;        // �ҵ�rotate֮�������ͷ  
	        back.next = null;           // �п�ѭ������  
	        return rotateHead;  
	}

	// �� LL���� modҪ��
	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	
	
	}
	 public static void main(String[] args) {  
	        ListNode head = new ListNode(1);  
	        ListNode n2 = new ListNode(2);  
	        ListNode n3 = new ListNode(3);  
	        ListNode n4 = new ListNode(4);  
	        ListNode n5 = new ListNode(5);  
	        head.next = n2;  
	        n2.next = n3;  
	        n3.next = n4;  
	        n4.next = n5;  
	          
	        ListNode rotateHead = new RotateList().rotateRight(head, 2);  
	       // rotateHead.print();  
	    }  
	 
	
}
