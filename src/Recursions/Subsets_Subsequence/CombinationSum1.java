package Recursions.Subsets_Subsequence;

import java.util.ArrayList;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7};
        subset(arr);
    }

    static void subset(int[] arr) {
        int index = 0;
        int target = 7;
        ArrayList<Integer> output = new ArrayList<>();
        solve(index, target, arr, output);
    }

    // time complexity: O(2^n) not exactly but somehow near to this.
    // this is the way to print all the combinations.
    // if want to return them in a 2d array list then just add those in base case.
    private static void solve(int index, int target, int[] arr, ArrayList<Integer> output) {

        if (index >= arr.length) {
            if (target == 0) {
                System.out.println(output);
                return;
            }
            return;
        }

        // pick case.
        if (arr[index] <= target) {
            // NOTE: the add function of arraylist takes linear time complexity.
            output.add(arr[index]);
            // even if we pick the index we will not increment the index till we reach
            // arr[index] > target
            solve(index, target - arr[index], arr, output);
            output.remove(output.size() - 1);
        }

        // not pick
        solve(index + 1, target, arr, output);
    }
}
