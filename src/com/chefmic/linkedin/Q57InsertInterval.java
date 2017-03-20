package com.chefmic.linkedin;

import com.chefmic.leetcode.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyuan on 3/18/17.
 */
public class Q57InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

    private int index(List<Interval> intervals, Interval newInterval, boolean front) {
        int start = 0, end = intervals.size() - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            Interval interval = intervals.get(mid);
            if (front) {
                if (newInterval.start >= interval.start && newInterval.start <= interval.end) {
                    return mid;
                } else if (newInterval.start < interval.start) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (newInterval.end >= interval.start && newInterval.end <= interval.end) {
                    return mid;
                } else if (newInterval.end < interval.start) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        /**
         * [1,2],[3,5],[6,7],[8,10],[12,16]
         */
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)
        );

        insert(new ArrayList<>(intervals), new Interval(-4, 1)).stream().forEach(interval -> {
            System.out.println(interval.start + " - " + interval.end);
        });
    }

}
