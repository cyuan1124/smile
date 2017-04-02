package com.chefmic.leetcode.list;

import com.chefmic.leetcode.ds.ListNode;

/**
 * Created by cyuan on 3/30/17.
 */
public class Q206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = runner;
            runner = head;
            head = tmp;
        }
        return dummy.next;
    }

}
