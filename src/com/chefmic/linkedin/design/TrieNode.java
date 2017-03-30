package com.chefmic.linkedin.design;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public boolean isWord;
    public char c;
    Map<Character, TrieNode> nodes;

    // Initialize your data structure here.
    public TrieNode() {
        nodes = new HashMap<>();
    }
}
