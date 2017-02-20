package com.chefmic.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by cyuan on 2/18/17.
 */
public class Q271EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str :strs) {
            sb.append('[').append(str.length()).append(']').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int indicator = s.indexOf(']', start);
            int length = Integer.valueOf(s.substring(start + 1, indicator));
            strs.add(s.substring(indicator + 1, indicator + 1 + length));
            start = indicator + 1 + length;
        }
        return strs;
    }

    @Test
    public void test() {
        List<String> strs = Arrays.asList("Today", "", "Is", "Saturday");
        decode(encode(strs)).stream().forEach(System.out::println);
    }

}
