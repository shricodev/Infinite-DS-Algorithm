package Searching.BinarySearching.OneDArray;

public class PeakIndexInMountainArr_LC {
    public static void main(String[] args) {
        // mountain array is the array where the elem goes on increasing once and then starts decteasing.
        // array shall not contain duplicate elements.
        int[] nums = {10,20,30,25,19,18,12};
        System.out.println(findPeakIndxRcrsn(nums, 0, nums.length - 1));
    }

    // this should return the index of the peak elem in the mountain array.
    static int findPeakIndxRcrsn(int[] arr, int start, int end) {

        int mid = start + (end - start) / 2;


        // base case.
        if (start >= end) {
            // or even we can return end cuz at one point start is going to be equal to end
            // which both will point to the bigger element in the array.
            return start; 
        }


        // since the array one half is sorted once in ascending order and other half in descending order.
        // so if we find a point when the mid is greater than the mid + 1 then we need to start looking in
        // the right portion. since we are in the descending order of the array.
        if (arr[mid] > arr[mid + 1]) {
            return findPeakIndxRcrsn(arr, start, mid);
        }

        // if not then we are in the ascending order so start is going to be the mid + 1 index.
        return findPeakIndxRcrsn(arr, mid + 1, end);

    }

    // iterative
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            // descending
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            // ascending.
            } else {
                start = mid + 1;
            }
            
        }
        return start; // or even we can return end index.
      } 
}
