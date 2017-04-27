package com.chefmic.linkedin.newQuestion;

//Sort a linked list using insertion sort.

import com.chefmic.leetcode.ds.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;

        InsertionSortList sort = new InsertionSortList();
        sort.insertionSortList(a);

    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode node = dummy;

            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }

            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;

    }
}
