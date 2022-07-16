package Sorting.Bubble;

import java.util.Arrays;

public class SortArr_IT {
    public static void main(String[] args) {
        // int[] arr1 = {1,2,5,4,8,9};
        int[] arr2 = { 5, 7, 9, 7, 4, 1 };
        // int[] arr3 = {1,2,3,4,5};
        // int[] arr4 = {1};
        // int[] arr5 = {};
        sortArr(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    // Bubble Sort - Stable algorithm
    // Best Time Complexity = O(n) -> when the arr is already sorted.
    // Worst/Avg Time Complexity = O(n^2) -> worst when the arr is sorted in reverse
    // order.
    static void sortArr(int[] arr) {

        // run for n - 1 times
        // this will handle even for the arr with length 0 or 1.
        for (int count = 1; count <= arr.length - 1; count++) {
            boolean swapped = false;
            // since after each count++ the largest one is going to settle down in the array
            // in the
            // last indexes so there is no sense in checking those so (- count).
            for (int sort = 1; sort < arr.length - count + 1; sort++) {
                // if the element in the courent index is smaller than the prev ind then swap.
                if (arr[sort] < arr[sort - 1]) {

                    int temp = arr[sort];
                    arr[sort] = arr[sort - 1];
                    arr[sort - 1] = temp;
                    swapped = true;

                }
            }
            // if there is no swapping for a particular value of count then it means that
            // the
            // array is already sorted.
            if (!swapped) {
                return;
            }
        }
    }
}
