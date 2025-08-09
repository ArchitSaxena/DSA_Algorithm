package com.archit.sorting;

import java.util.Arrays;

/**
 * Created by Archit Saxena
 * Date: 21/06/25
 * Time: 8:32 pm
 * Tekion Corp. © 2025
 */
public class SortingAlgos {
    public static void main(String[] args) {
        SortingAlgos obj = new SortingAlgos();
        int[] arr = new int[]{3, 2, 5, 4, 1};
        System.out.println(Arrays.toString(obj.bubbleSort(arr)));
        arr = new int[]{3, 2, 5, 4, 1};
        System.out.println(Arrays.toString(obj.selectionSort(arr)));
        arr = new int[]{3, 2, 5, 4, 1};
        System.out.println(Arrays.toString(obj.insertionSort(arr)));
        arr = new int[]{3, 2, 5, 4, 1};
        System.out.println(Arrays.toString(obj.cycleSort(arr)));
        arr = new int[]{3, 2, 5, 4, 1};
        System.out.println(Arrays.toString(obj.mergeSort(arr)));
        arr = new int[]{3,2,3,4,6,5};
        System.out.println(Arrays.toString(obj.findErrorNums(arr)));
    }

    public int[] bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    swapped = true;
                }
            }
            if (!swapped) return arr;
        }
        return arr;
    }

    public int[] selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        return arr;
    }

    public int[] insertionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else break;
            }
        }
        return arr;
    }

    // only works if arr has elements from 1 to n
    public int[] cycleSort(int arr[]) {
        int i = 0, len = arr.length;
        while (i < len) {
            if (arr[i] - 1 != i) {
                swap(arr, i, arr[i] - 1);
            } else
                i++;
        }
        return arr;
    }

    public int[] mergeSort(int[] arr) {
        int len = arr.length;
        int mid = len / 2;
        if (len == 1)
            return arr;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, len));

        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int[] finalArray = new int[left.length + right.length];
        int x = 0, i = 0, j = 0, leftLength = left.length, rightLength = right.length;
        while (i < leftLength && j < right.length) {
            if (left[i] < right[j]) {
                finalArray[x] = left[i];
                i++;
            } else {
                finalArray[x] = right[j];
                j++;
            }
            x++;
        }
        while (i < leftLength) {
            finalArray[x] = left[i];
            i++;
            x++;
        }
        while (j < rightLength) {
            finalArray[x] = right[j];
            j++;
            x++;
        }
        return finalArray;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] findErrorNums(int[] nums) {
        int i=0;
        int[] result= new int[2];
        while(i<nums.length){
            int curr= nums[i]-1;
            if(nums[curr]!=nums[i]){
                int temp= nums[curr];
                nums[curr]= nums[i];
                nums[i]= temp;
            }
            else
                i++;
        }
        System.out.println(Arrays.toString(nums));
        for(i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                result[0]= nums[i];
                result[1]=i+1;
            }
        }
        return result;
    }
}
