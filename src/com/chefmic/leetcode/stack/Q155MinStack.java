package com.chefmic.leetcode.stack;

import java.util.Stack;

public class Q155MinStack {

    private Stack<Integer> stack, min;

    /** initialize your data structure here. */
    public Q155MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min.push(x);
        } else {
            min.push(Math.min(x, min.peek()));
            stack.push(x);
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        Q155MinStack stack = new Q155MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(1);

        System.out.println(stack.getMin());
    }
}