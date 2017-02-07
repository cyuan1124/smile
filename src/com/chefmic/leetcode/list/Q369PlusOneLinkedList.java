package com.chefmic.leetcode.list;

import com.chefmic.leetcode.ds.ListNode;

import java.util.Stack;

/**
 * Created by cyuan on 2/3/17.
 */
public class Q369PlusOneLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.construct(9, 9, 9);
        head = plusOne(head);
        ListNode.print(head);
    }

    public static ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        boolean carry = true;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (carry) {
                carry = (node.val + 1 == 10);
                node.val = (node.val + 1) % 10;
            }
        }

        if (carry) {
            node = new ListNode(1);
            node.next = head;
            return node;
        }
        return head;

    }


}
