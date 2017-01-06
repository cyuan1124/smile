package com.chefmic.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by cyuan on 1/2/17.
 */
public class Q227BasicCalculatorII {

    public static void main(String[] args) {
        Q227BasicCalculatorII calculator = new Q227BasicCalculatorII();
        System.out.println(calculator.calculate("1+1"));
    }

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s + " ";
        Deque<Long> intStack = new LinkedList<>();
        Deque<Character> operatorStack = new LinkedList<>();

        long num = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (num == -1) {
                    num = c - '0';
                } else {
                    num = num * 10 + (c - '0');
                }
            } else {
                if (num != -1) {
                    intStack.offerLast(num);
                    num = -1;
                    // We got a number!
                    char lastOperator = operatorStack.isEmpty() ? ' ' : operatorStack.peekLast();
                    if (lastOperator == '*') {
                        long num1 = intStack.pollLast();
                        long num2 = intStack.pollLast();
                        intStack.offerLast(num1 * num2);
                        operatorStack.pollLast();
                    } else if (lastOperator == '/') {
                        long num1 = intStack.pollLast();
                        long num2 = intStack.pollLast();
                        intStack.offerLast(num2 / num1);
                        operatorStack.pollLast();
                    }
                }
                if (c != ' ') {
                    operatorStack.offerLast(c);
                }
            }
        }

        while (intStack.size() > 1) {
            long num1 = intStack.pollFirst();
            long num2 = intStack.pollFirst();
            switch (operatorStack.pollFirst()) {
                case '+':
                    intStack.offerFirst(num1 + num2);
                    break;
                case '-':
                    intStack.offerFirst(num1 - num2);
                    break;
            }
        }
        return intStack.isEmpty() ? 0 : intStack.pop().intValue();
    }

}
