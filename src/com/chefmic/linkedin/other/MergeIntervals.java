package com.chefmic.linkedin.other;

public class MergeIntervals {

    Node head = new Node(0, 0);
    int totalLength = 0;

    public void add(int start, int end) {
        if (start >= end) {
            return;
        }
        Node mover = head.next;
        Node prev = head;
        while (mover != null) {
            if (end < mover.start) {
                Node node = new Node(start, end);
                mover.pre.next = node;
                node.pre = mover.pre;
                node.next = mover;
                mover.pre = node;
                totalLength += end - start;
                break;
            } else if (start > mover.end) {
                prev = mover;
                mover = mover.next;
            } else {
                totalLength -= mover.end - mover.start;
                start = Math.min(start, mover.start);
                end = Math.max(end, mover.end);
                Node next = mover.next;
                mover.pre.next = mover.next;
                if (mover.next != null) {
                    mover.next.pre = mover.pre;
                }
                mover.next = null;
                mover.pre = null;
                mover = next;
            }
        }
        if (mover == null) {
            totalLength += end - start;
            prev.next = new Node(start, end);
            prev.next.pre = prev;
        }
    }

    public int getTotalLength() {
        return totalLength;
    }

    class Node {
        Node pre = null;
        Node next = null;
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
