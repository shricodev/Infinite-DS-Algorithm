package Sorting.Quick;

import java.util.Arrays;

// this is not a stable sorting algorithm.
// this is a in-place sorting algo and don use any extra memory space.
// avg/best time complexity: O(Nlogn)
// worst time complexity: O(N^2)

// space complexity: O(n)


public class QuickSort_RC {
    public static void main(String[] args) {
        int arr[] = {2, 5, 3, -3, -1, -22, 0, 8, 22, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int partition = partition(arr, start, end);

        // sort the left portion of the partition.
        quickSort(arr, start, partition - 1);
        // sort the right portion of the partition.
        quickSort(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int count = 0;

        // placing the pivot in the correct position.
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                count++;
            }
        }

        int pivotIndx = start + count;
        swap(arr, pivotIndx, start);

        int i = start;
        int j = end;

        while (i < pivotIndx && j > pivotIndx) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < pivotIndx && j > pivotIndx) {
                // swap(arr, i, j);
                // i++;
                // j--;
                /* OR */
                swap(arr, i++, j--);
            }
        }
        return pivotIndx;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
