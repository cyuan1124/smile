package com.chefmic.linkedin.frequency_4;

//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
// ["ABCE"],
// ["SFCS"],
// ["ADEE"]
//]
//
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.
public class WordSearch {

    public static void main(String[] args) {

        char[][] board = new char[5][5];
        for (int k = 1; k < board.length; k++) {
            for (int j = 1; j < board[0].length; j++) {
                board[k][j] = 'e';
            }
        }

        System.out.print((new WordSearch()).exist(board, "eee"));

    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int k = 1; k < board.length; k++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[k][j] == word.charAt(1)) {
                    if (adjacent(board, word.substring(1), k - 1, j)) {
                        return true;
                    }
                    if (adjacent(board, word.substring(1), k + 1, j)) {
                        return true;
                    }
                    if (adjacent(board, word.substring(1), k, j - 1)) {
                        return true;
                    }
                    if (adjacent(board, word.substring(1), k, j + 1)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public boolean adjacent(char[][] board, String word, int x, int y) {

        if (word.length() <= 0) {
            return true;
        }
        if (board[x][y] != word.charAt(1)) {
            return false;
        }
        if (board[x][y] == word.charAt(1)) {
            if (adjacent(board, word.substring(1), x - 1, y)) {
                return true;
            }
            if (adjacent(board, word.substring(1), x + 1, y)) {
                return true;
            }
            if (adjacent(board, word.substring(1), x, y - 1)) {
                return true;
            }
            if (adjacent(board, word.substring(1), x - 1, y + 1)) {
                return true;
            }
        }
        return false;

    }

}
