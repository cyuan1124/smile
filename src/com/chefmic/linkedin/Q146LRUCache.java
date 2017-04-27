package com.chefmic.linkedin;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 3/21/17.
 */
public class Q146LRUCache {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        assertEquals(1, cache.get(2));
        cache.put(3, 2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));       // returns 3
    }

    class LRUCache {

        private final Node head, tail;
        private final int cap;
        private int size;
        private Map<Integer, Node> hash; // Key -> Node

        public LRUCache(int capacity) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            cap = capacity;
            hash = new HashMap<>();
        }

        public int get(int key) {
            Node node = hash.get(key);
            if (node == null) {
                return -1;
            }
            moveToFirst(node);
            return node.val;
        }

        private void moveToFirst(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head.next;
            node.next.prev = node;

            head.next = node;
            node.prev = head;
        }

        public void put(int key, int value) {
            if (hash.containsKey(key)) {
                Node node = hash.get(key);
                node.val = value;
                moveToFirst(node);
            } else {
                if (cap == size) {
                    Node last = tail.prev;
                    last.prev.next = tail;
                    tail.prev = last.prev;
                    hash.remove(last.key);
                    size--;
                }
                Node node = new Node();
                node.val = value;
                node.key = key;
                node.next = head.next;
                node.next.prev = node;

                node.prev = head;
                head.next = node;

                size++;

                hash.put(key, node);
            }
        }

    }

    class Node {
        int val;
        Node prev, next;
        int key;
    }
}
