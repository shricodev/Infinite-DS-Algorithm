package Recursions.Subsets_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        // System.out.println(subsetApproach1(arr));
        System.out.println(subsetApproach2(arr));
    }

    // APPROACH FIRST: just change the data type of ans from arraylist to set to get rid of duplicates.
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
        
        // base case
        if (target == 0) ans.add(new ArrayList<>(output));
        else return;

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

    // time complexity: O(2^n) * k + n log n(n log n for sorting the array)(k is the avg length of combinations. since the add funcn of arrylist takes linear time complexity)
    // space complexity: k * x(x being no of combinations) 
    // this is probably the best approach to solve the qn.
    static ArrayList<ArrayList<Integer>> subsetApproach2(int[] arr) {
        Arrays.sort(arr);
        int index = 0;
        int target = 8;
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solveApproach2(index, target, arr, output, ans);
        return ans;
    }

    private static void solveApproach2(int index, int target, int[] arr, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> ans) {
        
        if (index >= arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(output));
                return;
            }
            return;
        }

        // for include
        if (arr[index] <= target) {
            output.add(arr[index]);
            // we are increasing the index once taken since no dup element available in one combn.
            solveApproach2(index + 1, target - arr[index], arr, output, ans);
            output.remove(output.size() - 1);
        }

        // for exclude. this makes the combination sum 2 diff from one.
        while (index + 1 < arr.length && arr[index] == arr[index + 1]) index++;

        solveApproach2(index + 1, target, arr, output, ans);
    }


}
