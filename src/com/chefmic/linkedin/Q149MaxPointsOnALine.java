package com.chefmic.linkedin;

import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q149MaxPointsOnALine {

    /**
     * ax + b = y
     * a*p1x + b = p1y
     * a*p2x + b = p2y
     * <p>
     * a = (p1y - p2y) / (p1x - p2x)
     * <p>
     * b = p1y - a*p1x
     */
    public int maxPoints(Point[] points) {
        if (points.length < 2) return points.length;
        Map<Line, Integer> counter = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                double slope = 1.0 * (p1.y - p2.y) / (p1.x - p2.x);
                double intersection = p1.y - slope * p1.x;

                Line line = new Line(slope, intersection);

                counter.put(line, counter.getOrDefault(line, 0) + 1);
            }
        }
        return counter.values().stream().max(Integer::compareTo).orElse(1);
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) // until either one of them is 0
        {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b; // either one is 0, so return the non-zero value
    }


    class Line {
        double slope;
        double intersectionX;

        public Line(double slope, double intersectionX) {
            this.slope = slope;
            this.intersectionX = intersectionX;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if (Double.compare(line.slope, slope) != 0) return false;
            return Double.compare(line.intersectionX, intersectionX) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(slope);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(intersectionX);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    @Test
    public void testGCD() {
        System.out.print(gcd(3, 9));
        System.out.print(gcd(27, 9));
    }

}
