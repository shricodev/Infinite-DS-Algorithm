package Searching.BinarySearching.OneDArray;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 5, 1, 3 };
        System.out.println(search(nums, 5));
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int peak = findPeakIndx(arr);

        if (arr[peak] == target) {
            return peak;
        } 

        int firstHalf = binarySearch(arr, target, start, peak);

        if (firstHalf != -1) {
            return firstHalf;
        }

        // search second half.
        return binarySearch(arr, target, peak + 1, end);
    }

    static int findPeakIndx(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
