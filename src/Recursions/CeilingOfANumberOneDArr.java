package Recursions;

public class CeilingOfANumberOneDArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 10, 11, 12};
        System.out.println(ceilingNumber(arr, 10, 0, arr.length - 1));
    }

    // this function should return the number itself from the array if the number greater then the number does not exist
    // or should return just the bigger number than the target element.
    static int ceilingNumber(int[] arr, int target, int start, int end) {

        // the code is same as the binary search to find n but the only difference 
        // is now instead of returning the index -1 it will return the element in the start index which should be the number just greater than the target element.
        if (start > end) {
            return arr[start];
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return arr[middle];
        }

        if (target < arr[middle]) {
            return ceilingNumber(arr, target, start, middle - 1);
        }

        return ceilingNumber(arr, target, middle + 1, end);
    } 
}
