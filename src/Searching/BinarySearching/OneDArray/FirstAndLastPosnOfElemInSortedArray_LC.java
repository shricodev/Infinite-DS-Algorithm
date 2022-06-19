package Searching.BinarySearching.OneDArray;

import java.util.Arrays;

// time complexity should be O(log n)
// QN: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FirstAndLastPosnOfElemInSortedArray_LC {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,10,12,10,11};
        System.out.println(Arrays.toString(searchRange(nums, 10)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartIndex(nums,  target);
        result[1] = findEndIndex(nums,  target);
        return result;
    }

    static int findStartIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else 
                start = mid + 1;
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    static int findEndIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
            }
        return index;
    }
}