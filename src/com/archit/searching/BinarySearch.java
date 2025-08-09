package com.archit.searching;

public class BinarySearch {

    public static void main(String args[]) {
        BinarySearch obj = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(obj.binarySearch(arr, 11));
    }

    public int binarySearch(int[] arr, int target) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

}