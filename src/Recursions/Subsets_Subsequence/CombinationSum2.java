package Recursions.Subsets_Subsequence;

import java.util.ArrayList;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(subsetApproach1(arr));
    }

    // APPROACH FIRST: just change the dara type of ans from arraylist to set to get rid of duplicates.
    // have no idea about set till now , so future me please modify the code and make it work :)
    // time complexity : O(2 ^ n) * k * logn. logn for set size extra since we are adding the ds in a set.
    static ArrayList<ArrayList<Integer>> subsetApproach1(int[] arr) {
        int index = 0;
        int target = 7;
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solveApproach1(index, target, arr, output, ans);
        return ans;
    }

    // time complexity: O(2^n) not exactly but somehow near to this.
    // this is the way to print all the combinations.
    private static void solveApproach1(int index, int target, int[] arr, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> ans) {
        
        if (index >= arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        // pick case.
        if (arr[index] <= target) {
            // NOTE: the add function of arraylist takes linear time complexity. 
            output.add(arr[index]);
            // since we are not allowed to take the same element time an again so we need to increment a index.
            solveApproach1(index + 1, target - arr[index], arr, output, ans);
            output.remove(output.size() - 1);
        }

        // not pick
        solveApproach1(index + 1, target, arr, output, ans);
    }





}
