package Sorting.Selection;

import java.util.Arrays;

public class sortArrSelection_IT {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 9, 7, 4, 1 };
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Selection Sort - Unstable algorithm
    // best -> O(n^2)
    // worst -> O(n^2)
    static void sortArr(int[] arr) {

        // running n - 1 loop
        for (int i = 0; i < arr.length; i++) {

            // finding the last index in which we are going to swap the max elem in the array.
            int lastInd = arr.length - i - 1;
            // finding the max ind.
            int maxElemInd = getMaxElemInd(arr, 0, lastInd);
            // using a swap method to swap the maxInd elem with the last index elem.
            swap(arr, maxElemInd, lastInd);
        }

    }

    static void swap(int[] arr, int swap1, int swap2) {

        // this does all the swap of the elem in the array.
        int temp = arr[swap1];
        arr[swap1] = arr[swap2];
        arr[swap2] = temp;

    }

    static int getMaxElemInd(int[] arr, int start, int end) {

        int max = start;
        
        for (int i = start; i <= end; i++) {
            
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
