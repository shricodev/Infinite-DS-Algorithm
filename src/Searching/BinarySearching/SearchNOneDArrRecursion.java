package Searching.BinarySearching;
import java.util.Arrays;

public class SearchNOneDArrRecursion {
    
    public static void main(String[] args) {
        int arr[] = {1,34,12,56,78,90,54,32,65,21,23,45,11,29};
        System.out.println(binarySearch(arr, 21, 0, arr.length - 1));
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        
        // for binary sort to work the array must be sorted in ascending order.
        Arrays.sort(arr);

        // this condition is true if the given element is not found in the array.
        // since the algorithm is dividing the array in half in each iteration so
        // there will be time when the array have start index greater than end index if the element not found
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (arr[middle] > target) {
            // we use return because the function has a return type int.
            return binarySearch(arr, target, start, middle - 1);
        }
        
        // if arr{middle} < target then this condition is executed.
        // we use return because the function has a return type int.
        return binarySearch(arr, target, middle + 1, end);

    }
}
