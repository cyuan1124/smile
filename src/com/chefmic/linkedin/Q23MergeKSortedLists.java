package com.chefmic.linkedin;

import com.chefmic.leetcode.ds.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cyuan on 3/18/17.
 */
public class Q23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        Arrays.stream(lists).forEach(node -> {
            if (node != null) {
                queue.add(node);
            }
        } );

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(5);

        mergeKLists(new ListNode[] {root});

    }

}
