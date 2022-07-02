package Searching.BinarySearching.OneDArray;

public class SmallestLetterGreaterThanTarget_LC {

    // EDGE CASE: if arr is ['a', 'b'] and target is 'z' then it should return 'a'.
    // QN: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

    public static void main(String[] args) {
        char[] arr = {'g'};
        System.out.println(smallLetterGreaterRecursive(arr, 'g', 0, arr.length - 1));
        // System.out.println(smallLetterGreaterIterative(arr, 'd'));
    }

    static char smallLetterGreaterRecursive(char arr[], char target, int start, int end) {
        
        // this will handle the edge case. what if the arr consist of a single element.
        // this handles also the case when we need to return the first element in the array when the 
        //  target element is in the last index of the array.
        if (start == arr.length) {
            return arr[0];
        }

        // this handle all the normal case when the target letter is not in the end of the array. 
        if (start > end) {
            return arr[start];
        }


        int middle = start + (end - start) / 2;

        if (target < arr[middle]) {
            return smallLetterGreaterRecursive(arr, target, start, middle - 1);
        }

        return smallLetterGreaterRecursive(arr, target, middle + 1, end);
    }

    static char smallLetterGreaterIterative(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }
        // this is the best way to do this qn but is hard to find 
        // return letters[start % letters.length];

        if (start == letters.length) {
            return letters[0];
        }

        return letters[start];

    }
}
