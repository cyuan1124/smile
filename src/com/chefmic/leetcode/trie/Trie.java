package com.chefmic.leetcode.trie;

/**
 * Created by cyuan on 2/1/17.
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        System.out.println(trie.search(".ad"));
    }

    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int start, TrieNode root) {
        if (root == null) return false;
        if (start == word.length) return root.isWord;
        if (word[start] == '.') {
            for (TrieNode node : root.children) {
                if (search(word, start + 1, node)) {
                    return true;
                }
            }
            return false;
        }
        if (root.children[word[start] - 'a'] == null) return false;
        return search(word, start + 1, root.children[word[start] - 'a']);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }

}
