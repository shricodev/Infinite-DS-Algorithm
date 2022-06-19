package Searching.BinarySearching.OneDArray;

public class SearchNOneDArrIteration {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(arr, 5));
    }

    // assuming the array is sorted.
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle  = start + (end - start) / 2;

            if (target < arr[middle]) {
                end = middle - 1;

            } else if (target > arr[middle]) {
                start = middle + 1;

            } else {
                // if both thesse conditons are not true then the middle element is the answer.
                return middle;
            }
        }
        // if not found return -1.
        return -1;

    }
}
