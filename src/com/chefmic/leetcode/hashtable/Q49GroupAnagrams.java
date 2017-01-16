package com.chefmic.leetcode.hashtable;

import java.util.*;

/**
 * Created by cyuan on 1/15/17.
 */
public class Q49GroupAnagrams {

    public static void main(String[] args) {
        for (List<String> list : groupAnagrams(new String[]{""})) {
            list.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
            System.out.println(list.size());
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> list = map.getOrDefault(sorted, new ArrayList<String>());
            list.add(str);
            map.put(sorted, list);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

}
