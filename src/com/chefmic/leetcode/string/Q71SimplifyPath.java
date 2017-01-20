package com.chefmic.leetcode.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by cyuan on 1/17/17.
 */
public class Q71SimplifyPath {

    public static void main(String[] args) {
        Q71SimplifyPath tester = new Q71SimplifyPath();
        System.out.println(tester.repeatedSubstringPattern("abcabcabcabd"));
    }

    public boolean repeatedSubstringPattern(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.length() % (i + 1) != 0) continue;
            if (str.matches(String.format("(%s)*", str.substring(0, i + 1))))
                return true;
        }
        return false;
    }

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String p : paths) {
            if (p.isEmpty() || ".".equals(p)) continue;
            if ("..".equals(p)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offer(p);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
