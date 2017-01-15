package com.chefmic.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cyuan on 1/15/17.
 */
public class Q299BullsandCows {

    public static void main(String[] args) {
        System.out.print(getHint("1122", "2211"));
    }

    public static String getHint(String secret, String guess) {
        int a = 0, b = 0;
        Map<Character, Integer> secretSet = new HashMap<>();
        Map<Character, Integer> guessSet = new HashMap<>();

        for (int i = 0; i < guess.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                a++;
            } else {
                if (secretSet.getOrDefault(g, 0) > 0) {
                    b++;
                    secretSet.put(g, secretSet.get(g) - 1);
                } else {
                    guessSet.put(g, guessSet.getOrDefault(g, 0) + 1);
                }

                if (guessSet.getOrDefault(s, 0) > 0) {
                    b++;
                    guessSet.put(s, guessSet.get(s) - 1);
                } else {
                    secretSet.put(s, secretSet.getOrDefault(s, 0) + 1);
                }
            }
        }
        return String.format("%dA%dB", a, b);
    }

}
