package com.chefmic.linkedin.palindrome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cyuan on 4/4/17.
 */
public class Q131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        solve(result, s.toCharArray(), 0, new ArrayList<>());
        return result;
    }

    private void solve(List<List<String>> result, char[] string, int startIndex, List<String> list) {
        if (startIndex == string.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = startIndex; i < string.length; i++) {
                if (isPalindrome(string, startIndex, i)) {
                    list.add(new String(string, startIndex, i - startIndex + 1));
                    solve(result, string, i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(char[] string, int start, int end) {
        while (start < end) {
            if (string[start++] != string[end--]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String str = "aab";
        partition(str).stream().forEach(list -> list.stream().forEach(System.out::println));
    }

}
