package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q305NumberOfIslandsII {

    @Test
    public void test() {
        int[][] positions = {{7, 0}};
        List<Integer> islands = numIslands2(8, 2, positions);
        assertEquals(1, islands.size());
        islands.stream().forEach(System.out::println);
    }

    int[] dx = {-1, 0, +1, 0};
    int[] dy = {0, -1, 0, +1};

    // m rows and n column
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        List<Integer> adjacentRoots = new ArrayList<>();
        for (int[] position : positions) {
            adjacentRoots.clear();
            for (int i = 0; i < dx.length; i++) {
                int x = position[0] + dx[i];
                int y = position[1] + dy[i];
                if (x < 0 || y < 0 || x == m || y == n) {
                    continue;
                }
                int index = n * x + y;
                if (roots[index] != -1) {
                    int r = roots[index];
                    while (roots[r] != r) {
                        r = roots[r];
                    }
                    if (!adjacentRoots.contains(r)) {
                        adjacentRoots.add(r);
                    }
                }
            }

            if (adjacentRoots.isEmpty()) {
                // No nearby island, assign root to itself
                roots[n * position[0] + position[1]] = n * position[0] + position[1];
                count++;
                result.add(count);
            } else {
                roots[n * position[0] + position[1]] = adjacentRoots.get(0);
                for (int i = 1; i < adjacentRoots.size(); i++) {
                    roots[adjacentRoots.get(i)] = adjacentRoots.get(0);
                }
                count -= (adjacentRoots.size() - 1);
                result.add(count);
            }
        }
        return result;
    }

}
