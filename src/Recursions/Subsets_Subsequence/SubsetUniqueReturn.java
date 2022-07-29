package Recursions.Subsets_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetUniqueReturn {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3};
        System.out.println(subset(arr));
    }

    // time complexity: O(2 ^ N) + (2 ^ N * log(2^N)) -> this extra 2 pow n log n is for sorting the array of size 2 ^ N
    // space complexity: O(2 ^ N)
    static ArrayList<ArrayList<Integer>> subset(int[] arr) {
        int index = 0;
        Arrays.sort(arr);
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(arr, index, output, ans);
        return ans;
    }

    private static void solve(int[] arr, int index, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> ans) {
        
        if (index >= arr.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // include
        output.add(arr[index]);
        solve(arr, index + 1, output, ans);
        output.remove(output.size() - 1);
        
        while (index + 1 < arr.length && arr[index] == arr[index + 1]) index++;
        
        // exclude
        solve(arr, index + 1, output, ans);

    }
}
