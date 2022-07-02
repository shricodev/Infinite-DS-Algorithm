package DataSructures.Arrays;

public class MaxInOneDArray {
    public static void main(String[] args) {
        int[] arr = {1, 2,3, 67, 89, 90, 12};
        // System.out.println(findMaxIteration(arr));
        findMaxRecursion(arr, 0);
        System.out.println(maxInt);
        
    }

    static int findMaxIteration(int[] arr) {
        // suppose the first index to be the maximum.
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        return maxValue;
    }

    public static int maxInt = 0;

    static void findMaxRecursion(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }

        if (arr[index] > maxInt) {
            maxInt = arr[index];
        }

        findMaxRecursion(arr, index + 1);
    } 
}
