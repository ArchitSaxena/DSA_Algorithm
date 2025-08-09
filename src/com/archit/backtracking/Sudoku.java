package com.archit.backtracking;

import java.util.Objects;

/**
 * Created by Archit Saxena
 * Date: 06/07/25
 * Time: 3:39 pm
 * Tekion Corp. © 2025
 */
public class Sudoku {
    public static void main(String[] args) {
        Sudoku obj = new Sudoku();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        obj.solve(board);
        obj.display(board);
    }
    public void display(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }
    }

    public boolean solve(char[][] board) {
        int row = -1;
        int col = -1;
        boolean flag = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]=='.') {
                    row = i;
                    col = j;
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (flag)
            return true;

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = (char)(num+'0');
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]==(char)(num+'0'))
                return false;
        }

        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j]==(char)(num+'0'))
                return false;
        }

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j]==(char)(num+'0'))
                    return false;
            }
        }
        return true;
    }
}
