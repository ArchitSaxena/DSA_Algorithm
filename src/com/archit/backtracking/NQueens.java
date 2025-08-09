package com.archit.backtracking;

/**
 * Created by Archit Saxena
 * Date: 05/07/25
 * Time: 12:34 am
 * Tekion Corp. © 2025
 */
public class NQueens {
    public static void main(String[] args) {
        NQueens obj= new NQueens();
        boolean[][] board= new boolean[8][4];
        System.out.println("Number of solutions: " + obj.queens(board, 0));
    }
    public int queens(boolean[][] board, int row){
        if(row==board.length){
            display(board);
            return 1;
        }
        int count=0;
        for(int col=0;col<board[row].length;col++){
            if(isSafe(board, row, col)){
                board[row][col]=true;
                count= count+queens(board, row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    public void display(boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j])
                    System.out.print('Q');
                else System.out.print('_');
            }
            System.out.println();
        }
        System.out.println();
    }
    public boolean isSafe(boolean[][] board, int row, int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][col])
                    return false;
                if(board[i][j] && j-i==col-row)
                    return false;
                if(board[i][j] && j+i==col+row)
                    return false;
            }
        }
        return true;
    }
}
