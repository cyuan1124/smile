package com.chefmic.linkedin;

import com.chefmic.leetcode.Interval;
import org.junit.Test;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Q56MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return Collections.emptyList();
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval top = stack.pop();
            Interval interval = intervals.get(i);
            if (top.end >= interval.start) {
                stack.push(new Interval(top.start, Math.max(top.end, interval.end)));
            } else {
                stack.push(top);
                stack.push(interval);
            }
        }
        return stack;
    }

    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge2(List<Interval> intervals) {
        // write your code here
        intervals.sort(Comparator.comparingInt(i -> i.start));

        int i = 1;
        while ( i < intervals.size()) {
            Interval prior = intervals.get(i - 1);
            Interval cur = intervals.get(i);

            if (cur.start <= prior.end) {
                intervals.remove(i);
                intervals.set(i - 1, new Interval(prior.start, Math.max(prior.end, cur.end)));
            } else {
                i++;
            }
        }

        return intervals;
    }

    @Test
    public void test() {
        List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(2, 6),
                new Interval(8, 10), new Interval(15, 18)));
        merge2(intervals).forEach(i -> System.out.println("[" + i.start + " " + i.end + "]"));
    }

}
