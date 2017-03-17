package com.chefmic.linkedin;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 */
public class Q205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> dict = new HashMap<>();
        Map<Character, Character> reverse = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (dict.getOrDefault(cs, ct) != ct || reverse.getOrDefault(ct, cs) != cs) {
                return false;
            }
            dict.put(cs, ct);
            reverse.put(ct, cs);
        }
        return true;
    }

    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isIsomorphic("egg", "add"));
        assertFalse(isIsomorphic("foo", "bar"));
    }

}
