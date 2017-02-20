package com.chefmic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 2/14/17.
 */
public class Q348DesignTicTacToe {

    class TicTacToe {

        final int[][] panel;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            panel = new int[n][n];
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            panel[row][col] = player;
            if (checkCol(col, player) || checkRow(row, player) || ((row == col) && (checkDiagnol(player) || checkDianolReverse(player)))) {
                return player;
            }
            return 0;
        }

        private boolean checkRow(int row, int player) {
            for (int num : panel[row]) {
                if (num != player) return false;
            }
            return true;
        }

        private boolean checkCol(int col, int player) {
            for (int i = 0; i < panel.length; i++) {
                if (panel[i][col] != player) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkDiagnol(int player) {
            for (int i = 0; i < panel.length; i++) {
                if (panel[i][i] != player) return false;
            }
            return true;
        }

        private boolean checkDianolReverse(int player) {
            int length = panel.length;
            for (int i = 0; i < panel.length; i++) {
                if (panel[i][length - 1 - i] != player) return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        TicTacToe ticTacToe = new TicTacToe(3);
        assertEquals(0, ticTacToe.move(0, 0, 1));
        assertEquals(0, ticTacToe.move(0, 2, 2));
        assertEquals(0, ticTacToe.move(2, 2, 1));
        assertEquals(0, ticTacToe.move(1, 1, 2));
        assertEquals(0, ticTacToe.move(2, 0, 1));
        assertEquals(0, ticTacToe.move(1, 0, 2));
        assertEquals(1, ticTacToe.move(2, 1, 1));
    }

}
