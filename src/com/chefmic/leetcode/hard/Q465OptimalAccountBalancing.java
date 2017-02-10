package com.chefmic.leetcode.hard;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by cyuan on 2/9/17.
 */
public class Q465OptimalAccountBalancing {

    public static void main(String[] args) {
        int[][] transactions = new int[][]{{10,11,6},{12,13,7},{14,15,2},{14,16,2},{14,17,2},{14,18,2}};
        System.out.print(minTransfers(transactions));
        Pattern.matches("(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)(e(\\+|-)?\\d+)?", "3.0");
    }

    public static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>(); // ID -> Dept
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        PriorityQueue<Integer> borrow = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> lend = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer dept : map.values()) {
            if (dept > 0) lend.add(dept);
            if (dept < 0) borrow.add(-dept);
        }

        int count = 0;
        for (int b : borrow) {
            if (lend.contains(b)) {
                borrow.remove(b);
                lend.remove(b);
                count++;
            }
        }
        while (!borrow.isEmpty() && !lend.isEmpty()) {
            int b = borrow.poll();
            int l = lend.poll();
            if (b == l) {
            } else if (b > l) {
                borrow.add(b - l);
            } else {
                lend.add(l - b);
            }
            count++;
        }
        return count + borrow.size() + lend.size();
    }

}
