package Sorting.Cyclic;

import java.util.Arrays;

public class SortArrCyclic {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // when given the range of array from (1 to N) or (o to n - 1) to sort in always use the cyclic sort method.
    // this is even useful to find the missing elem in the array kind of a questions.
    static void cyclicSort(int[] arr) {

        int ithInd = 0;
        while (ithInd < arr.length) {
            
            // correct index for the elem in the ith index.
            int correctInd = arr[ithInd] - 1;

            if (arr[ithInd] != arr[correctInd]) {
                swap(arr, ithInd, correctInd);

            } else {
                ithInd++;
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
