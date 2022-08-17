package DynamicProgramming;

import java.util.Arrays;

public class CountSubset {
    public static void main(String[] args) {
        int[] arr = { 12, 1, 3 };
        int n = arr.length;
        int target = 4;
        // for recurison
        System.out.println(countWithKRec(arr, n - 1, target));

        // for memoization
        int dp[][] = new int[n][target + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(countWithKMemo(arr, n - 1, target, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(countWithKTabu(n, target, arr, dp));

        // for space optimization
        System.out.println(countWithKSpOpt(n, target, arr));
    }

    // link: https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
    // time complexity: O(2^n)
    // space complexity: O(n)
    static int countWithKRec(int[] arr, int ind, int target) {

        // if at any index the target is 0, then just return 1;
        if (target == 0)
            return 1;

        // out of bounds base case;
        if (ind == 0) {
            if (target == arr[0]) {
                return 1;
            }
            return 0;
        }

        int pick = 0;

        if (arr[ind] <= target) {
            pick = countWithKRec(arr, ind - 1, target - arr[ind]);
        }

        int notPick = countWithKRec(arr, ind - 1, target);

        return pick + notPick;
    }

    // time complexity: O(nXtarget)
    // space complexity: O(n) + O(nXtarget)
    static int countWithKMemo(int[] arr, int ind, int target, int[][] dp) {

        // if at any index the target is 0, then just return 1;
        if (target == 0)
            return 1;

        // out of bounds base case;
        if (ind == 0) {
            if (target == arr[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int pick = 0;

        if (arr[ind] <= target) {
            pick = countWithKMemo(arr, ind - 1, target - arr[ind], dp);
        }

        int notPick = countWithKMemo(arr, ind - 1, target, dp);

        return dp[ind][target] = pick + notPick;
    }

    // time complexity: O(nXtarget)
    // space complexity: O(nXtarget)
    static int countWithKTabu(int n, int target, int[] arr, int[][] dp) {

        // this is the target = 0, base case.
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // out of bounds base case.
        if (arr[0] <= target)
            dp[0][arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {

            for (int sum = 0; sum <= target; sum++) {

                int pick = 0;
                
                if (arr[ind] <= sum) {
                    pick = dp[ind - 1][sum - arr[ind]];
                }
                
                int notPick = dp[ind - 1][sum];
                
                dp[ind][sum] = pick + notPick;
                
            }
        }
        return dp[n - 1][target];
    }

    // time complexity: O(nXtarget)
    // space complexity: O(target)
    static int countWithKSpOpt(int n, int target, int[] arr) {

        int[] prev = new int[target + 1];
        
        // this is the target = 0, base case.
        prev[0] = 1;

        // out of bounds base case.
        if (arr[0] <= target)
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            
            int[] current = new int[target + 1];

            for (int sum = 0; sum <= target; sum++) {

                int pick = 0;
                
                if (arr[ind] <= sum) {
                    pick = prev[sum - arr[ind]];
                }
                
                int notPick = prev[sum];
                
                current[sum] = pick + notPick;
                
            }
            prev = current;
        }
        return prev[target];

    }

}
