package Searching.BinarySearching.TwoDArray;

import java.util.Arrays;

public class SearchNStrictlySorted_LC {
    public static void main(String[] args) {
        int[][] arr = {
            {1,3,5,7,8,9},
            {10,11,16,20},
            {23,30,34,60},
            };
        System.out.println(Arrays.toString(search(arr, 13)));

    }


    // this is the mixture of linear and binary search.
    // Time complexity GUESS = O(row * logn)
    // Space complexity = O(1)
    static int[] search(int[][] arr, int target) {

        // it will find the floor of the no in each row and if the floor is found then checks if the arr[row][floor]
        // is equals to the target no.

        for (int row = 0; row < arr.length; row++) {
            int floorInd = findFloor(arr[row], target, 0, arr[row].length - 1);

            // this checks for the condn when the start elem of the row is bigger than the target element.
            if (floorInd == -1) {
                return new int[] {-1, -1};
            }

            if (arr[row][floorInd] == target) {
                return new int[] {row, floorInd};
            }
        }
        return new int[]{-1, -1};
    }

    
    // it return the index of the no itself if the no is in the array 
    // else it will return the floor of the no.
    static int findFloor(int[] arr, int target, int start, int end) {

        int mid = start + (end - start) / 2;
        
        if (start > end) {
            return end;
        }

        /*this line is not needed.
         * cuz the above base case will handle.
        */
        // if (arr[mid] == target) {
        //     return mid;
        // }

        if (target < arr[mid]) {
            return findFloor(arr, target, start, mid - 1);
        }

        return findFloor(arr, target, mid + 1, end);
    }
}
