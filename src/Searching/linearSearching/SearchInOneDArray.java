package Searching.linearSearching;

public class SearchInOneDArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4, 5, 6, 7, 8, 9, 10};
        System.out.println(searchArr(arr, -1));
    }

    static int searchArr(int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        // linear search: 
        // time complexity 
        // Worst -> O(n) & Best -> O(1)
        
        // for (int index = 0; index < arr.length; index++) {
        //     if (arr[index] == target) {
        //         return index;
        //     }
        // }

        // better to use the for-each loop if we want to return an array element rather than the index value. 
        for (int elem : arr) {
            if (elem == target) {
                return elem;
            }
        }

        // if not found return -1. but if the target is -1 itself then how to know if it is the target -1 found or the not found -1 so we use the MAX_VALUE which returns a random huge digit integer.
        // this is another convention to denote not found.  
        return Integer.MAX_VALUE;

    }
}
