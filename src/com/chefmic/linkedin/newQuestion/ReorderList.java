package com.chefmic.linkedin.newQuestion;

import com.chefmic.leetcode.ds.ListNode;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (!stack.isEmpty() && stack.peek() != curr.next) {
            ListNode temp = stack.pop(); //n
            temp.next = curr.next;//n->2
            curr.next = temp;//1->n
            curr = curr.next.next; //  1->n->2 ( ��ʱcurrΪ2)
        }

    }
}
