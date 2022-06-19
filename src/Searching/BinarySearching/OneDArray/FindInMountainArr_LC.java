package Searching.BinarySearching.OneDArray;

public class FindInMountainArr_LC {
    public static void main(String[] args) {
        /*
        Edge case to handle.
         *  Input: array = [1,2,3,4,5,3,1], target = 3
            Output: 2
            Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
         */
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(search(arr, 3));
    }

    static int search(int[] arr, int target) {

        // first we are trhing to find the peak element in the array.
        int peakIndx = peakIndexInMountainArray(arr);

        // if we find the target element in the ascending order of the array then simply return the value.
        int ascending = ascendingBS(arr, target, 0, peakIndx);

        if (ascending != -1) {
            return ascending;
        }
        // if not search in the descending array.
        int descending = descendingBS(arr, target, peakIndx + 1, arr.length - 1);
        return descending;
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
            
        }
        return start; // or even we can return end index.
      } 


    static  int ascendingBS(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }
        
        if (target < arr[middle]) {
            return ascendingBS(arr, target, start, middle - 1);
        } else {
            return ascendingBS(arr, target, middle + 1, end);
}
    }

    static  int descendingBS(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }
        
        if (target < arr[middle]) {
            return descendingBS(arr, target, middle + 1, end);
        } else {
            return descendingBS(arr, target, start , middle - 1);
        }
    }


}
