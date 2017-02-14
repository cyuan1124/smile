package com.chefmic.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q200NumberOfIslands {

    public static void main(String[] agrs) {
        Q200NumberOfIslands tester = new Q200NumberOfIslands();
        List<String> maps = Arrays.asList("11000","11000","00100","00011");
        char[][] map = new char[maps.size()][];
        for (int i = 0; i < maps.size(); i++) {
            map[i] = maps.get(i).toCharArray();
        }
        System.out.println(tester.numIslands(map));
    }

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
