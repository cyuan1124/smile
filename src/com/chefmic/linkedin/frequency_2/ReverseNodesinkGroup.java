package com.chefmic.linkedin.frequency_2;

import java.awt.List;
//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5 

//������ʲô��˼ �� �� K��nodeλ1�鷴ת
//�ȷ�˵k=2����2��һ�鷴ת  1-2 ��ת��2-1  3-4 ��ת��4-3 5��Ϊ����2�����Բ���ת
//k=3���Ƿ�ת��3-2-1 ����45 ����3������

public class ReverseNodesinkGroup {
//��д��helper���� ��������������Ƿ�ת ��pre+1 ��next-1����һ��linkedlist
        /* a linked list:  0��dummy head
	     * 0->1->2->3->4->5->6
	     * |last cur   |   
	     * pre        next
	     * after call pre = reverse(pre, next)
	     * 
	     * 0->3->2->1->4->5->6
	     *          |  |
	     *          pre next
	     */
	//д���ͺ���ͨ��linkedlistһ��  �Ĳ�while �� cur==next����while
	private ListNode reverse(ListNode pre,ListNode next){
		ListNode last=pre.next; //pre-1 ��ת�� nextָ�� next-4 
		ListNode cur=last.next;//�൱��2;
		while(cur!=next){         //��һ��
			last.next=cur.next;   //1-3
		  cur.next=pre.next;      //2-1
		  pre.next=cur;           //0-2
		  cur=last.next;          //cur2��3  ���Ե�һ��������0-2-1-3 curr��3
		}               //�ڶ��������� 0-3-2-1  Ȼ��һ��ʼ��1-4�� ����0-3-2-1-4
	return last; //һֱ��1 whileѭ����û��� ��Ϊ1����4������ÿ�η��صľ�����һ�ֵ�dummy node
	}
//���������棬����LL�Ĺ�����ÿ�ζ�������ÿ�ε���k���ڵ㣬�Ϳ���ʹ��pre��head.next��������ķ�����ת�ˡ������ˡ�
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
	    if(head==null||k==1){return head;}
	    ListNode dummy =new ListNode(0);
	    dummy.next=head;
	    ListNode pre=dummy;
	    int count=0;
	    while(head!=null){
	    	count++;
	    	if(count%k==0){ //��Ϊ�Ǵ�0��ʼ���� ���� ��k=3ʱ��0..4..7
	    		pre=reverse(pre, head.next);  // ��Ϊhelper��������ȥ��ʱ����0,4 Ȼ��ת123
	    		//���������һ�γ�ʼ��ʱ�򴫽�ȥ0-2 1�Լ���ת��Ӱ��, count=0  ʱ�򷵻�1
	    	head=pre.next;// 1.next��2   ���Ե�count����0ʱ�� ʱ����û�з�ת head �Զ�����һλ
	    	}else{
	    		head=head.next;
	    	}
	    }
		return dummy.next;
		
	    }
}
