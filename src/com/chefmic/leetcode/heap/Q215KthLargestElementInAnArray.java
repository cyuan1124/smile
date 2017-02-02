package com.chefmic.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * Created by cyuan on 1/21/17.
 */
public class Q215KthLargestElementInAnArray {

    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(nums).forEach(heap::add);
        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }

        return heap.poll();

    }

}
