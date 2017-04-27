package com.chefmic.linkedin.newQuestion;

import com.chefmic.leetcode.ds.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
