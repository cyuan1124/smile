package com.chefmic.leetcode.uber;

import java.util.*;

/**
 * Created by cyuan on 2/2/17.
 */
public class Q249GroupShiftedStrings {

    public static void main(String[] args) {
        Q249GroupShiftedStrings tester = new Q249GroupShiftedStrings();
        tester.groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"})
                .stream().forEach(list -> {
                    list.forEach(str -> System.out.print(str + " "));
                    System.out.println();
        });
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

}
