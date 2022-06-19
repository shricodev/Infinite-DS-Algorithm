package Searching.BinarySearching.OneDArray;

public class FloorOfANumber {
    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 14};
        System.out.println(floorNumber(arr, 15, 0, arr.length - 1));
    }

    // this function should return the number itself from the array if the number smaller then the target does not exist
    // or should return just the smaller number than the target element.

    // return the greater rnumber <= target.
    static int floorNumber(int[] arr, int target, int start, int end) {

        // this is to handle the edge case, what if the target is less than the first index in the array
        if (arr[0] > target) {
            return Integer.MIN_VALUE;
        }

        // the code is same as the binary search to find n but the only difference 
        // is now instead of returning the index -1 it will return the element in the start index which should be the number just lesser than the target element.
        if (start > end) {
            return arr[end];
            // if we want to return the index then just return the end.
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return arr[middle];
        }

        if (target < arr[middle]) {
            return floorNumber(arr, target, start, middle - 1);
        }

        return floorNumber(arr, target, middle + 1, end);
    } 
}

