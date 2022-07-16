package Sorting.Selection;

import java.util.Arrays;

public class SortArraySelection_RC {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 9, 7, 4, 1, -1 };
        selectionRc(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionRc(int[] arr, int i) {

        if (i >= arr.length) {
            return;
        }

        int lastInd = arr.length - i - 1;
        int maxElemInd = getMaxElemInd(arr, 0, lastInd);
        swap(arr, lastInd, maxElemInd);

        selectionRc(arr, i + 1);
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

    static void swap(int[] arr, int swap1, int swap2) {

        // this does all the swap of the elem in the array.
        int temp = arr[swap1];
        arr[swap1] = arr[swap2];
        arr[swap2] = temp;
    }
}
