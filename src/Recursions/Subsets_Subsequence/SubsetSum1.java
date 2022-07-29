package Recursions.Subsets_Subsequence;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum1 {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        System.out.println(subset(arr));
    }

    // time complexity: O(2 ^ N) + (2 ^ N * log(2^N)) -> this extra 2 pow n log n is for sorting the array of size 2 ^ N
    // space complexity: O(2 ^ N)
    static ArrayList<Integer> subset(int[] arr) {
        int index = 0;
        // taking the initial sum as 0
        int sum = 0;
        ArrayList<Integer> sumArr = new ArrayList<>();
        solve(arr, index, sum, sumArr);
        // return the sum array sorted.
        Collections.sort(sumArr);
        return sumArr;
    }

    private static void solve(int[] arr, int index, int sum, ArrayList<Integer> sumArr) {
        if (index >= arr.length) {
            sumArr.add(sum);
            return;
        }

        // include
        solve(arr, index + 1, sum + arr[index], sumArr);


        // exclude
        solve(arr, index + 1, sum, sumArr);

    }
}
