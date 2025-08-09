package com.archit.sorting;



/*Dutch National Flag Algorithm
The dutch national flag algorithm involves sorting the nums array by partitioning it into 3 segments.
nums[0]...nums[low - 1] : This part should consist of all zeroes.
nums[low]...nums[mid - 1] : This part should consist of all ones.
nums[mid]...nums[end of array] : This part should consist of all twos.

We basically look for 3 possible cases for 3 values of mid here,
Case 1 → Value of mid is 0
Swap it with low because we want all 0's to be before mid.
Case 2 → Value of mid is 1
Increment mid because 1 is at the correct position it should be.
Case 3 → Value of mid is 2
We swap it with high because we want all 2's to be after high.
 */
public class DutchNationalFlagAlgo {
    public static void main(String[] args) {
        DutchNationalFlagAlgo obj = new DutchNationalFlagAlgo();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        obj.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}