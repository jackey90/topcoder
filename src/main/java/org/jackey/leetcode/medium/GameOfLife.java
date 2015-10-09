package main.java.org.jackey.leetcode.medium;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.Arrays;

/**
 * Created by jackey90 on 15/10/9.
 * <p/>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p/>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p/>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p/>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

public class GameOfLife {
    private int max_x;
    private int max_y;

    public void gameOfLife(int[][] board) {
        max_x = board.length - 1;
        max_y = board[0].length - 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                applyRule(board, i, j, countOfLive(board, i, j));
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }


    private int countOfLive(int[][] board, int x, int y) {
        int count = 0;
        if (x - 1 >= 0) {
            if (isLive(board[x - 1][y])) {
                count++;
            }
            if (y - 1 >= 0) {
                if (isLive(board[x - 1][y - 1])) {
                    count++;
                }
            }
            if (y + 1 <= max_y) {
                if (isLive(board[x - 1][y + 1])) {
                    count++;
                }
            }
        }

        if (x + 1 <= max_x) {
            if (isLive(board[x + 1][y])) {
                count++;
            }
            if (y - 1 >= 0) {
                if (isLive(board[x + 1][y - 1])) {
                    count++;
                }
            }
            if (y + 1 <= max_y) {
                if (isLive(board[x + 1][y + 1])) {
                    count++;
                }
            }
        }

        if (y - 1 >= 0) {
            if (isLive(board[x][y - 1])) {
                count++;
            }
        }

        if (y + 1 <= max_y) {
            if (isLive(board[x][y + 1])) {
                count++;
            }
        }


        return count;
    }

    private void applyRule(int[][] board, int x, int y, int count) {
        int life = board[x][y];
        if (life == 1) {
            if (count < 2 || count > 3) {
                board[x][y] = -1;
            }
        }
        if (life == 0) {
            if (count == 3) {
                board[x][y] = 2;
            }
        }

    }


    //  -1 is for live->dead, 2 is for dead -> live
    private boolean isLive(int life) {
        if (life == 1 || life == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{1,1}};
        new GameOfLife().gameOfLife(board);
        JOutPrint.JPrint( Arrays.deepToString(board));
    }
}
