package com.chefmic.linkedin;

import com.chefmic.crack.ds.Node;
import org.junit.Test;

import java.util.*;

/**
 * Given a string S and a string T,
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 */
public class Q76MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int left = 0, right = 0, match = t.length(), minLength = Integer.MAX_VALUE;
        String minWindow = "";
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] map = new int[256];
        for (char c : arr2) {
            map[c]++;
        }
        while (right != arr1.length) {
            map[arr1[right]]--;
            if (map[arr1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while(map[arr1[left]] < 0) {
                    map[arr1[left++]]++;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                }
                match++;
                map[arr1[left++]]++;
            }
            right++;
        }
        return minWindow;
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

        String content = "lintcode is the best online judge";
        Arrays.stream(content.split("\\s+")).forEach(System.out::println);

        PriorityQueue<Node> pq = new PriorityQueue<>(5, Comparator.comparing(node -> node.name));
    }

}
