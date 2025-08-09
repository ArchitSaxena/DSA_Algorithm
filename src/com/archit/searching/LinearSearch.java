package com.archit.searching;

/**
 * Created by Archit Saxena
 * Date: 18/06/25
 * Time: 1:53 am
 * Tekion Corp. © 2025
 */
public class LinearSearch {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5,6,7,8,9};
        int target= 8;
        int res=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target)
                res= i;
        }
        System.out.println(res);
    }
}
