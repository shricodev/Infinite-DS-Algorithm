package Searching.BinarySearching.OneDArray;

// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
// import java.util.Arrays;

public class FirstAndLastOccurence_LC {
    public static void main(String[] args) {
        // this array should be in a sorted state.
        // int[] nums = {1,2,5,6,7,7,7,8,9,10};
        // int[] ansHolder = new int[2];

        // ITERATIVE APPROACH
        // ansHolder[0] = findFirstIndx(nums, 7);
        // ansHolder[1] = findLastIndx(nums, 7);
        
        // System.out.println(findFirstIndx(nums, 6));
        // System.out.println(Arrays.toString(ansHolder));


        // RECURSIVE APPROACH
        // ansHolder[0] = firstIndexRcrsn(nums, 7, 0, nums.length - 1, -1);
        // ansHolder[1] = lastIndexRcrsn(nums, 7, 0, nums.length - 1, -1);

        // System.out.println(Arrays.toString(ansHolder));
    }

    static int findFirstIndx(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
        int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                // store the potential ans in the ans variable.
                ans = mid;
                // even if we find the element in the array we still need to keep looking on the left side of the array.
                end = mid - 1;

            } else if (target < nums[mid]) {
                end = mid - 1;
                
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }

    static int findLastIndx(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
        int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                // even if we find the element in the array we still need to keep looking on the right side of the array.
                start = mid + 1;

            } else if (target < nums[mid]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int firstIndexRcrsn(int[] arr, int target, int start, int end, int answer) {

        if (start > end) {
            return answer;
        }

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            answer = mid;
            end = mid - 1;
            return firstIndexRcrsn(arr, target, start, end, answer);

        } else if (target < arr[mid]) {

            return firstIndexRcrsn(arr, target, start, mid - 1, answer);
        }

        return firstIndexRcrsn(arr, target, mid + 1, end, answer);
        }

    static int lastIndexRcrsn(int[] arr, int target, int start, int end, int answ) {

        if (start > end) {
            return answ;
        }

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            answ = mid;
            start = mid + 1;
            return lastIndexRcrsn(arr, target, start, end, answ);
        }

        if (target < arr[mid]) {
            return lastIndexRcrsn(arr, target, start, mid - 1, answ);
        }

        return lastIndexRcrsn(arr, target, mid + 1, end, answ);
    }
}