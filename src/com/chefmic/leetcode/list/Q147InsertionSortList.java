package com.chefmic.leetcode.list;

import com.chefmic.leetcode.ds.ListNode;

/**
 * Created by cyuan on 1/15/17.
 */
public class Q147InsertionSortList {

    public static void main(String[] args) {
        ListNode head = ListNode.construct(6, 5, 3, 1, 8, 7, 2, 4);
        head = insertionSortList(head);
        ListNode.print(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = null;

        while (head != null) {
            if (dummy.next == null) {
                dummy.next = head;
                tail = head;
                head = head.next;
                tail.next = null;
            } else if (head.val >= tail.val) {
                tail.next = head;
                head = head.next;
                tail = tail.next;
                tail.next = null;
            } else {
                ListNode runner = dummy;
                while (runner.next != null && runner.next.val < head.val) {
                    runner = runner.next;
                }
                ListNode next = runner.next;
                runner.next = head;
                head = head.next;
                runner.next.next = next;
            }
        }
        return dummy.next;
    }

}
