package com.chefmic.linkedin.frequency_1;

import java.util.Stack;

//Given a string containing just the characters '(' and ')', 
//find the length of the longest valid (well-formed) parentheses substring.
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.print(new LongestValidParentheses().longestValidParentheses("))((())()())"));

    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();//stack����±�
        int maxLen = 0;
        int accumulatedLen = 0;     //�ȷ�˵  ")()())"
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);  //�ڶ�char stack��push1
            } else {
                if (stack.isEmpty()) {
                    accumulatedLen = 0; //��һchar accumulatedLen=0 ��Ϊ)
                } else {
                    int matchedLeft = stack.pop();  //��3char matched pop 1
                    int matchedLen = i - matchedLeft + 1; //matchedLen =2-1+1=2  ����i���Ǳ���ƥ���ϵ��������±� matchleft���Ǳ���ƥ���ϵ��������±�
                    if (stack.isEmpty()) { //��ʱstackΪ����
                        accumulatedLen = accumulatedLen + matchedLen; //acL=2
                        matchedLen = accumulatedLen; //matched Len=2
                    } else {
                        matchedLen = i - stack.peek();
                    }
                    maxLen = Math.max(maxLen, matchedLen); //��̬ά�� maxLen ֮ǰ����󳤶Ⱥͱ���match������󳤶ȱ�
                }
            }
        }
        return maxLen;
    }
}