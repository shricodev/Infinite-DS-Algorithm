package Sorting.Merge;

import java.util.Arrays;

public class MergeSortInPlace_RC {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1, -1 };
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int strt, int end) {
        
        // base case
        if (end - strt == 1) {
            return;
        }

        int mid = strt + (end - strt) / 2;

        // left
        mergeSortInPlace(arr, strt, mid);
        // right
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, strt, mid, end);

    }

    static void mergeInPlace(int arr[], int strt, int mid, int end) {
        // temp array.
        int[] mix = new int[end - strt];

        int leftPointer = strt;
        int rightPointer = mid;
        int mixPointer = 0;

        while (leftPointer < mid && rightPointer < end) {
            if (arr[leftPointer] < arr[rightPointer]) {
                mix[mixPointer] = arr[leftPointer];
                leftPointer++;
            } else {
                mix[mixPointer] = arr[rightPointer];
                rightPointer++;
            }
            mixPointer++;
        }

        while (leftPointer < mid) {
            mix[mixPointer] = arr[leftPointer];
            leftPointer++;
            mixPointer++;
        }

        while (rightPointer < end) {
            mix[mixPointer] = arr[rightPointer];
            rightPointer++;
            mixPointer++;
        }

        // now we have the sorted array in mix. so use a for loop to add the mix elem in
        // arr.
        for (int i = 0; i < mix.length; i++) {
            arr[strt + i] = mix[i];
        }

    }
}
