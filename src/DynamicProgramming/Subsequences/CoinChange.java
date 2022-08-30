package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;
        System.out.println(countWaysRec(arr, target, n - 1));

        // for dp -> memoization
        long[][] dp = new long[n][target + 1];
        for (long[] ls : dp) {
            Arrays.fill(ls, -1);
        }
        System.out.println(countWaysMemo(arr, target, n - 1, dp));

        // for tabulation
        for (long[] ls : dp) {
            Arrays.fill(ls, 0);
        }
        System.out.println(countWaysTabu(arr, target, dp, n));


        // for space optimizaiton
        System.out.println(countWaysSpOpt(arr, target, dp, n));
    }

    // time complexity: O(exponential)
    // space complexity: > O(N)
    // link: https://www.codingninjas.com/codestudio/problems/ways-to-make-coin-change_630471
    static int countWaysRec(int[] arr, int target, int ind) {

        if (ind == 0) {
            if (target % arr[0] == 0)
                return 1;
            return 0;
        }

        int notTake = countWaysRec(arr, target, ind - 1);
        int take = 0;

        if (arr[ind] <= target)
            take = countWaysRec(arr, target - arr[ind], ind);

        return take + notTake;
    }

    // time complexity: O(n x target)
    // space complexity: O(n x target) + O(target)
    static long countWaysMemo(int[] arr, int target, int ind, long[][] dp) {

        if (ind == 0) {
            if (target % arr[0] == 0)
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return (long) dp[ind][target];

        long notTake = countWaysMemo(arr, target, ind - 1, dp);
        long take = 0;

        if (arr[ind] <= target)
            take = countWaysMemo(arr, target - arr[ind], ind, dp);

        return dp[ind][target] = take + notTake;
    }


    static long countWaysTabu(int[] arr, int target, long[][] dp, int n) {
        
        for (int tgt = 0; tgt <= target; tgt++) {
            if (tgt % arr[0] == 0) {
                dp[0][tgt] = 1;
            }
        }

        for (int ind = 1; ind < n; ind++) {

            for (int tgt = 0; tgt <= target; tgt++) {

                long take = 0;

                long notTake = dp[ind - 1][tgt];

                if (arr[ind] <= tgt)
                    take = dp[ind][tgt - arr[ind]];

                dp[ind][tgt] = take + notTake;
            }
        }
        return dp[n - 1][target];
    }


    static long countWaysSpOpt(int[] arr, int target, long[][] dp, int n) {

        long[] prev = new long[target + 1];
        
        for (int tgt = 0; tgt <= target; tgt++) {
            if (tgt % arr[0] == 0) {
                prev[tgt] = 1;
            }
        }

        for (int ind = 1; ind < n; ind++) {

            long[] curr = new long[target + 1];
            
            for (int tgt = 0; tgt <= target; tgt++) {

                long take = 0;
                long notTake = 0;

                if (ind > 0) notTake = prev[tgt];

                if (arr[ind] <= tgt)
                    take = curr[tgt - arr[ind]];

                curr[tgt] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];
    }

}
