package com.chefmic.linkedin;

import org.junit.Test;

import java.util.*;

/**
 * Write a function to find all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule.
 */
public class Q187RepeatedDNASequences {
    int flag = (1 << 20) - 1;

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return Collections.<String>emptyList();
        }

        int[] dict = new int[26];
        dict['A' - 'A'] = 0; // 00
        dict['C' - 'A'] = 1; // 01
        dict['G' - 'A'] = 2; // 10
        dict['T' - 'A'] = 3; // 11
        List<String> result = new ArrayList<>();
        // Hash -> Counter
        Map<Integer, Integer> set = new HashMap<>();

        int hash = convert(s.substring(0, 10), dict);
        set.put(hash, 1);

        for (int i = 10; i < s.length(); i++) {
            hash <<= 2;
            hash += dict[s.charAt(i) - 'A'];
            hash &= flag;

            System.out.println(String.format("%16s", Integer.toBinaryString(hash)).replace(' ', '0'));

            if (set.getOrDefault(hash, 0) == 1) {
                result.add(s.substring(i - 9, i + 1));
            }
            set.put(hash, 1 + set.getOrDefault(hash, 0));
        }

        return result;
    }

    private int convert(String DNA, int[] dict) {
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash <<= 2;
            hash += dict[DNA.charAt(i) - 'A'];
        }
        return hash;
    }

    @Test
    public void test() {
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").forEach(System.out::println);
    }
}
