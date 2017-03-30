package com.chefmic.linkedin.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.nodes.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                newNode.c = c;
                node.nodes.put(c, newNode);
            }
            node = node.nodes.get(c);
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.nodes.containsKey(c)) {
                return false;
            }
            node = node.nodes.get(c);
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.nodes.containsKey(c)) {
                return false;
            }
            node = node.nodes.get(c);
        }
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.isWord) {
                return true;
            } else {
                for (TrieNode sub : node.nodes.values()) {
                    queue.offer(sub);
                }
            }
        }
        return false;
    }
}