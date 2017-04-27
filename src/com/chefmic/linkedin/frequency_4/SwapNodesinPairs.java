package com.chefmic.linkedin.frequency_4;

import com.chefmic.leetcode.ds.ListNode;

public class SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(5);
        a1.next = a2;
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        a2.next = b1;
        b1.next = b2;
        (new SwapNodesinPairs()).swapPairs(a1);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        //p1-1  p2-2  p3-3
        ListNode p1 = head, p2 = head.next, p3 = p2.next;
        head = p2;
        while (true) {
            p2.next = p1; //2->1

            if ((p3 == null) || (p3.next == null)) {
                p1.next = p3;
                break;
            } else {
                p1.next = p3.next;
            }

            p1 = p3;
            p2 = p3.next;
            p3 = p2.next;
        }

        return head; //2
    }
}



