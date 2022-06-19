package Searching.BinarySearching.OneDArray;

public class OrderAgnosticBinarySearchToFindN {
    public static void main(String[] args) {
        
        int[] arr = {100, 80, 60, 40, 20, 10};

        if (arr[0] < arr[arr.length - 1]) {
            System.out.println(ascendingBS(arr, 10, 0, arr.length - 1));
        }
        System.out.println(descendingBS(arr, 10, 0, arr.length - 1));

    }

    static  int ascendingBS(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }
        
        if (target < arr[middle]) {
            return ascendingBS(arr, target, start, middle - 1);
        } else {
            return ascendingBS(arr, target, middle + 1, end);
        }
    }

    static  int descendingBS(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }
        
        if (target < arr[middle]) {
            return descendingBS(arr, target, middle + 1, end);
        } else {
            return descendingBS(arr, target, start , middle - 1);
        }
    }
}
