package com.chefmic.linkedin;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 3/30/17.
 */
public class Q20ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default: {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char prev = stack.pop();
                    if ((c == ')' && prev == '(')
                            || (c == ']' && prev == '[')
                            || (c == '}' && prev == '{')) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertTrue(isValid("()"));
    }

}
