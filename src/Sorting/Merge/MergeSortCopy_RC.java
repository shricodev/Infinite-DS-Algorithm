package Sorting.Merge;

import java.util.Arrays;

// space complexity = O(N) since we will be having N arrays with single elements.
// time complexity = O(Nlogn)
public class MergeSortCopy_RC {
    public static void main(String[] args) {
        int[] arr = {8,5,6,4,2,0,1,-1};
        int[] ans = mergeSort(arr); // arr = mergeSort(arr) -> if wish to modify the same array.
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort(int[] arr) {
        // base case.
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        // Recursive leap of faith. just believe that these will sort the left and right side
        // of the array.
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        
        int[] mixed = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int mixedPointer = 0;

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] < right[rightPointer]) {
                mixed[mixedPointer] = left[leftPointer];
                leftPointer++;
            } else {
                mixed[mixedPointer] = right[rightPointer];
                rightPointer++;
            }
            // since one element is sure to be added in the mixed array.
            mixedPointer++;
        }

        // it may be possible that anyone of the array is bigger than the other one.
        // any one of the below loop will only get executed.
        while(leftPointer < left.length) {
            mixed[mixedPointer] = left[leftPointer];
            leftPointer++;
            mixedPointer++;
        }

        while (rightPointer < right.length) {
            mixed[mixedPointer] = right[rightPointer];
            rightPointer++;
            mixedPointer++;
        }

        return mixed;
    }
}
