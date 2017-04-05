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

        String INFINITE = "infinite";

        if (points.length < 3) return points.length;

        int max = 0;//用于返回的结果，即共线点的最大个数
        Map<String, Integer> map = new HashMap<String, Integer>(); //保存同一个斜率的点的个数

        for (int i = 0; i < points.length; i++) {//以每一个点为固定点
            map.clear();
            int duplicate = 1;//记录跟固定点重合的个数

            for (int j = 0; j < points.length; j++) {//遍历其他点，求其与固定点之间的斜率
                if (i == j) continue;//如果是自己，跳过
                String slope = "";//斜率

                if (points[i].x == points[j].x && points[i].y == points[j].y) {//如果跟固定点重合
                    duplicate++;
                    continue;
                } else if (points[i].x == points[j].x) {//如果跟固定点在同一条竖线上，斜率设为最大值
                    slope = INFINITE;
                } else {//计算该点与固定点的斜率
                    int diffX = points[i].x - points[j].x;
                    int diffY = points[i].y - points[j].y;
                    int gcd = gcd(Math.abs(diffX), Math.abs(diffY));
                    slope = String.format("%c%d/%d", ((diffX < 0 && diffY > 0) || (diffX > 0 && diffX < 0)) ? '-' : ' ',
                            diffY / gcd, diffX / gcd);
                }
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
            }

            //更新最优解
            if (map.size() == 0) {//如果map为空
                max = duplicate > max ? duplicate : max;
            } else {
                for (String key : map.keySet()) {
                    max = Math.max((duplicate + map.get(key)), max);
                }
            }
        }
        return max;
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

    @Test
    public void testGCD() {
        System.out.println(gcd(-3, 9));
        System.out.println(gcd(27, 9));
    }

}
