package Important450_DSA.Arrays;

import java.util.Arrays;

public class ReverseOneDArray {
    public static void main(String[] args) {
        int[] array1 = {1,2, 3, 4, 67, 89, 345};
        reverseArrRecursively(array1, 0, array1.length - 1);

        System.out.println(Arrays.toString(array1));
    }

    static void reverseArrRecursively(int[] arr, int start, int end) {

        if (start > end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp; 

        reverseArrRecursively(arr, start + 1, end - 1);
    }
}
