package Searching.BinarySearching.OneDArray;

public class FindIndexOfAnElemInInfiniteArray {
    
    // TIME COMPLEXITY: O(log N)
    public static void main(String[] args) {
        // wee are not supposed to use arr.length method so we need to find the start and end index
        // of the array. This is the same approach as binary search but in reverse order.
        // Reference Explanation: https://youtu.be/W9QJ8HaRvJQ?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=5280s

        // NOTE: if we try to find the element higher than the last index element it will throw  an error of index out of bound (since we are probiding a fix size array).
        // since this is an infinite array so this must not be a problem.
        int[] infiniteArr = {1,2,3,7,9,10,45,67,90,100,200,300,500,600};
        System.out.println(rangeFinder(infiniteArr, 1));
    }

    static int rangeFinder(int[] arr, int target) {
        // we find the index of the element using chunks of blocks and keep increasing the start and end by double and will 
        // see if  the target element is less than the end index element.
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            // now the start is going to be prev end + 1.
            int temp = end + 1; // new start.
            // double the chunk.
            // end = previous end + size of box * 2
            end = end + (end - start + 1) * 2; // to use the old start in the formulae we are storing the start in temp.
            start = temp;
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int middle  = start + (end - start) / 2;

            if (target < arr[middle]) {
                end = middle - 1;

            } else if (target > arr[middle]) {
                start = middle + 1;

            } else {
                // if both thesse conditons are not true then the middle element is the answer.
                return middle;
            }
        }
        // if not found return -1.
        return -1;
    }
}
