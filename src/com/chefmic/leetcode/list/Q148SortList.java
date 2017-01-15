package com.chefmic.leetcode.list;

import com.chefmic.leetcode.ds.ListNode;

/**
 * Created by cyuan on 1/3/17.
 */
public class Q148SortList {

    public static void main(String[] args) {
        ListNode head = ListNode.construct(1);
        ListNode.print(head);

        Q148SortList sorter = new Q148SortList();
        head = sorter.sortList(head);
        ListNode.print(head);
    }

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            head = removeSmallest(head, dummy);
        }
        ;
        return dummy.next;
    }

    ListNode removeSmallest(ListNode head, ListNode newHead) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode smallest = dummy;
        while (runner.next != null) {
            if (runner.next.val < smallest.next.val) {
                smallest = runner;
            }
            runner = runner.next;
        }

        // smallest.next is the smallest node
        ListNode min = smallest.next;
        smallest.next = min.next;
        min.next = null;

        runner = newHead;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = min;
        return dummy.next;
    }

}
