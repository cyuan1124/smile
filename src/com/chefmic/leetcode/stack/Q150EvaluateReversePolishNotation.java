package com.chefmic.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q150EvaluateReversePolishNotation {

    @Test
    public void test() {
        assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    /**
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     **/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Integer num = null;
            try {
                num = Integer.parseInt(token);
            } catch (Exception e) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                        break;
                }
                continue;
            }
            stack.push(num);
        }
        return stack.pop();
    }
}
