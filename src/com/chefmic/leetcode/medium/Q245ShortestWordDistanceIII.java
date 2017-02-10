package com.chefmic.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyuan on 2/9/17.
 */
public class Q245ShortestWordDistanceIII {

    public static void main(String[] args) {
        Q245ShortestWordDistanceIII tester = new Q245ShortestWordDistanceIII();
        System.out.print(tester.shortestWordDistance(new String[]{"abcdefg", "!@3asdsd", "sdjiqwen", "abcdefg", "ASdkmcq", "abcdefg", "asdgnjdhb", "ASdqwet2ewq"},
                "abcdefg", "abcdefg"));
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> i1 = new ArrayList<Integer>();
        List<Integer> i2 = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) i1.add(i);
            if (word2.equals(words[i])) i2.add(i);
        }

        int p1 = 0, p2 = 0;
        int min = words.length + 1;
        while (p1 < i1.size() && p2 < i2.size()) {
            if (i1.get(p1) == i2.get(p2)) {
                p1++;
            } else {
                int distance = i1.get(p1) - i2.get(p2);
                min = Math.min(min, Math.abs(distance));
                if (distance > 0) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }
        return min;
    }

}
