package com.archit.searching;

import java.util.List;

public class RolColBinarySearch {
    public static void main(String[] args) {
        RolColBinarySearch obj = new RolColBinarySearch();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = obj.findElementInMatrix(matrix, 11);
        System.out.println("Index of the Element: " + list);
    }

    public List<Integer> findElementInMatrix(int[][] matrix, int target) {
        List<Integer> list = List.of(-1, -1);
        if (matrix == null || matrix.length == 0)
            return list;
        int start = 0, end = matrix[0].length-1;
        while(start<matrix.length && end>=0){
            if(target== matrix[start][end]){
                return List.of(start, end);
            }
            if(target< matrix[start][end]){
                end--;
            }
            else{
                start++;
            }
        }
        return list;
    }
}
