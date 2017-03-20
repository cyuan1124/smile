package com.chefmic.linkedin;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by cyuan on 3/18/17.
 */
public class Q150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String operator : tokens) {
            if (Character.isDigit(operator.charAt(0)) ||
                    (operator.length() > 1 && Character.isDigit(operator.charAt(1)))) {
                stack.push(operator);
                continue;
            }
            int op1 = Integer.valueOf(stack.pop());
            int op2 = Integer.valueOf(stack.pop());
            switch (operator) {
                case "+":
                    stack.push(String.valueOf(op1 + op2));
                    break;
                case "-":
                    stack.push(String.valueOf(op2 - op1));
                    break;
                case "*":
                    stack.push(String.valueOf(op1 * op2));
                    break;
                case "/":
                    stack.push(String.valueOf(op2 / op1));
                    break;
            }
        }
        return Integer.valueOf(stack.pop());
    }

    @Test
    public void test() {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
