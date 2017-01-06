package com.chefmic.leetcode.ds;

/**
 * Created by cyuan on 1/3/17.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            if (listNode.next != null) {
                System.out.print(" -> ");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode construct(int... nums) {
        ListNode head = null;
        ListNode runner = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            if (head == null) {
                head = node;
                runner = node;
            } else {
                runner.next = node;
                runner = runner.next;
            }
        }
        return head;
    }

}
