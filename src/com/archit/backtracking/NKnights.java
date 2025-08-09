package com.archit.backtracking;

/**
 * Created by Archit Saxena
 * Date: 05/07/25
 * Time: 12:59 am
 * Tekion Corp. © 2025
 */
public class NKnights {
    public static void main(String[] args) {
        NKnights obj = new NKnights();
        boolean[][] board = new boolean[4][4];
        System.out.println("Number of solutions: " + obj.knights(board, 0, 0, 4));
    }

    public int knights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            return 1;
        }
        int count = 0;
        if (row == board.length - 1 && col == board[0].length)
            return 0;
        if (col == board.length) {
            return knights(board, row + 1, 0, knights - 1);
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count = count + knights(board, row, col+1, knights - 1);
            board[row][col] = false;
        }
        knights(board, row, col+1, knights);
        return count;
    }

    public void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j])
                    System.out.print('K');
                else System.out.print('_');
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //r-1,c-2
                //r-1, c+2
                //r+1, c-2
                //r+1,c+2
                //r-2, c-1
                //r-2,c+1
                //r+2,c+1
                //r+2,c-1
                if (board[i][j]) {
                    if ((row - 1 == i && col - 2 == j) || (row - 1 == i && col + 2 == j)
                            || (row - 2 == i && col - 1 == j) || (row - 2 == i && col + 1 == j))
                        return false;
                }
            }
        }
        return true;
    }
}
