package Sorting.Insertion;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 9, 7, 4, 1 };
        insertionS(arr);
        System.out.println(Arrays.toString(arr));
    }

    // best time complexity: O(N) -> when the array is already sorted.
    // worst case complexity: O(N^2) when the array is sorted in the descending order.
    static void insertionS(int[] arr) {

        // this loop will run till the n - 2 index. Bcuz for i equal to last indx then the inner loop will 
        // throw and index error.
        // IMPORTANT: for every i sort the arr till the i + 1 index.
        for (int i = 0; i < arr.length - 1; i++) {

            // since we cannot check the index 0 with j - 1 which will throw the index error 
            // so j has to be greater then zero.
            for (int j = i + 1; j > 0; j--) {

                if (arr[j] < arr[j - 1 ]) {
                    swap(arr, j, j - 1);

                } else {
                    // this is the thing that makes the time complexity less for this particular sorting algo.
                    // since the array till the index will already be sorted.
                    break;
                }
            }
        }
    }


    static void swap(int[] arr, int start, int end) {

        // this does all the swap of the elem in the array.
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

    }
}
