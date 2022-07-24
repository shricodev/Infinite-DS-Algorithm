package DataSructures.Arrays;

import java.util.Arrays;

public class ReverseOneDArray {
    public static void main(String[] args) {
        int[] array1 = {1,2, 3, 4, 67, 89, 345};
        // reverseArrParameterized(array1, 0, array1.length - 1);
        reverseArrFunctionally(array1, 0, array1.length);
        System.out.println(Arrays.toString(array1));
    }

    static void reverseArrParameterized(int[] arr, int start, int end) {

        if (start > end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp; 

        reverseArrParameterized(arr, start + 1, end - 1);
    }

    // here we are nto using the pointer for the left and right index
    static void reverseArrFunctionally(int arr[], int i, int n) {

        if (i >= n / 2) return;

        swap(arr, i, n-i-1);

        reverseArrFunctionally(arr, i + 1, n);
    }

    private static void swap(int arr[], int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
