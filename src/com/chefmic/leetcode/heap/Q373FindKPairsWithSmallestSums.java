package com.chefmic.leetcode.heap;

import java.util.*;

/**
 * Created by cyuan on 1/21/17.
 */
public class Q373FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        Q373FindKPairsWithSmallestSums tester = new Q373FindKPairsWithSmallestSums();
        int[] nums1 = new int[] {1, 1, 2};
        int[] nums2 = new int[] {1, 2, 3};
        for (int[] pair : tester.kSmallestPairs(nums1, nums2, 3)) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }

    class Pair {
        int left, right;
        public final int sum;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
            this.sum = left + right;
        }
    }

    Comparator<Pair> comparator = new Comparator<Pair>() {

        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.sum, p2.sum);
        }
    };

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);
        int i1 = 0, i2 = 0;
        while (queue.size() < k) {
            queue.add(new Pair(nums1[i1], nums2[i2]));
            if (i1 == nums1.length - 1) {
                i2++;
                continue;
            }

            if (i2 == nums2.length - 1) {
                i1++;
                continue;
            }
            if (nums1[i1 + 1] - nums1[i1] > nums2[i2 + 1] - nums2[i2]) {
                i2++;
            } else {
                i1++;
            }
        }

        List<int[]> res = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            res.add(new int[] { pair.left, pair.right});
        }
        return res;
    }


}
