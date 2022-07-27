package Recursions.Subsets_Subsequence;

import java.util.ArrayList;

public class OneSubSetSumK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2 };
        subset(arr);
    }

    // here the point is to not use any global variable to keep the track of.
    static void subset(int[] arr) {
        int sum = 4;
        int s = 0;
        int index = 0;
        ArrayList<Integer> output = new ArrayList<>();
        solve(arr, sum, s, index, output);

    }

    private static boolean solve(int[] arr, int sum, int s, int index, ArrayList<Integer> output) {

        if (index >= arr.length) {

            if (s == sum) {
                System.out.println(output);
                return true;
            }
            // condition is not satisfied.
            return false;
        }

        // include
        output.add(arr[index]);
        s += arr[index];

        // if any of the recursive call returns us the true then there is no need to do
        // future recursion calls;
        if (solve(arr, sum, s, index + 1, output) == true) return true;

        output.remove(output.size() - 1);
        s -= arr[index];

        // exclude
        // if any of the recursive call returns us the true then there is no need to do
        // future recursion calls;
        if (solve(arr, sum, s, index + 1, output) == true) return true;

        // if none of the recursion calls gives the ans then return false;
        return false;

    }
}
