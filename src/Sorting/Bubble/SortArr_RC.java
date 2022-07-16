package Sorting.Bubble;

import java.util.Arrays;

public class SortArr_RC {
    public static void main(String[] args) {
        int arr[] = {1,2,6,8,4,9,10};
        bubbleSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int arr[], int endIndx) {

        if (endIndx == 0) {
            return;
        }

        for (int i = 0; i < endIndx; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, endIndx - 1);
    }
}
