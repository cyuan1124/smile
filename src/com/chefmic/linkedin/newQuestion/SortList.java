package com.chefmic.linkedin.newQuestion;

import com.chefmic.leetcode.ds.ListNode;
//Sort a linked list in O(n log n) time using constant space complexity.

//merge sort 
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;  //��ǰ��νض� 1��2
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; //fast ��2λ��ʼ ��ô 2.4.6 slow 1 2 3 ��ô�����ܳ�����6����7slow����3
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //����������� linkedlist merge
    //�� merget sortһģһ��
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        // ֱ�ӰѶ��ಿ������
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }


}
