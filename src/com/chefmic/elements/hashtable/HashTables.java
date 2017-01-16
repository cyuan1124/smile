package com.chefmic.elements.hashtable;

import java.util.*;

/**
 * Created by cyuan on 1/15/17.
 */
public class HashTables {

    /**
     * Q1 Test for Palindromic Permutations
     */
    public static boolean canFormPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int even = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1 && ++even > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Q2 Is An Anonymous Letter Constructable
     */
    public static boolean isLetterConstructable(String letter, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character c : letter.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Character c : magazine.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) - 1);
                if (charCount.get(c) == 0) {
                    charCount.remove(c);
                }
                if (charCount.isEmpty()) {
                    break;
                }
            }
        }
        return charCount.isEmpty();
    }

    /**
     * Q6 Find The Nearest Repeated Entries In An Array
     */
    public static int findNearestRepetition(List<String> entries) {
        Map<String, Integer> wordToLatestIndex = new HashMap<>();
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < entries.size(); i++) {
            if (wordToLatestIndex.containsKey(entries.get(i))) {
                distance = Math.min(distance, i - wordToLatestIndex.get(wordToLatestIndex.get(i)));
            }
            wordToLatestIndex.put(entries.get(i), i);
        }
        return distance;
    }

    /**
     * Q9 Find The Longest Subarray With Distinct Entries
     */
    public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
        Map<Integer, Integer> mostRecentOccurrence = new HashMap<>();
        int longestDupFreeSubarrayStartIdx = 0, result = 0;
        for (int i = 0; i < A.size(); i++) {
            Integer dupIdx = mostRecentOccurrence.put(A.get(i), i);
            if (dupIdx != null) {
                if (dupIdx >= longestDupFreeSubarrayStartIdx) {
                    result = Math.max(result, i - longestDupFreeSubarrayStartIdx);
                    longestDupFreeSubarrayStartIdx = dupIdx + 1;
                }
            }
        }
        result = Math.max(result, A.size() - longestDupFreeSubarrayStartIdx);
        return result;
    }

    /**
     * Q10 Find The Length of A Longest Contained Interval
     */
    public static int longestContainedRange(List<Integer> A) {
        Set<Integer> entries = new HashSet<>(A);
        int maxIntervalSize = 0;

        while (!entries.isEmpty()) {
            int a = entries.iterator().next();
            entries.remove(a);
            int lowerBound = a - 1;
            while (entries.contains(lowerBound)) {
                entries.remove(lowerBound);
                lowerBound--;
            }

            int upperBound = a + 1;
            while (entries.contains(upperBound)) {
                entries.remove(upperBound);
                upperBound++;
            }

            maxIntervalSize = Math.max(upperBound - lowerBound - 1, maxIntervalSize);
        }
        return maxIntervalSize;
    }
}
