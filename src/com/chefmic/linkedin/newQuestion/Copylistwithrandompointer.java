package com.chefmic.linkedin.newQuestion;

public class Copylistwithrandompointer {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;// head ����1�� ���³�2
        }
    }

    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;// head ����1�� ���³�2

        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next; //1'
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) { // 2.next!=null
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
