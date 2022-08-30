package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class MinimumCoins {

    public static void main(String[] args) {
        int[] arr = { 12, 1, 3 };
        int n = arr.length;
        int targetSum = 4;

        // for recursion
        int ans = minmCoinsRec(arr, targetSum, n - 1);
        if (ans >= (int) 1e8)
            System.out.println(-1);
        else
            System.out.println(ans);

        // for memoization
        int[][] dp = new int[n][targetSum + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        ans = 0;
        ans = minmCoinsMemo(arr, targetSum, n - 1, dp);
        if (ans >= (int) 1e8)
            System.out.println(-1);
        else
            System.out.println(ans);

        // for tabulation
        ans = 0;
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        minmCoinsTabu(arr, targetSum, n, dp);
        ans = dp[n - 1][targetSum];
        if (ans >= (int) 1e8)
            System.out.println(-1);
        else
            System.out.println(ans);

        // for space optimizaiton 2 row
        ans = minmCoinsSpOpt2Row(arr, targetSum, n);
        if (ans >= (int) 1e8) System.out.println(-1);
        else System.out.println(ans);

        // for space optimizaiton one row
        System.out.println(minmCoinsSpOpt1Row(arr, targetSum, n));
    }

    // time complexity: O(exponential)
    // space complexity: O(target)
    // links: https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091
    static int minmCoinsRec(int[] arr, int targetSum, int ind) {

        if (targetSum == 0) return 0;
        
        if (ind == 0) {
            if (targetSum % arr[0] == 0) {
                return targetSum / arr[0];
            }
            return (int) 1e8;
        }

        int take = (int) 1e8;

        if (arr[ind] <= targetSum) {
            take = 1 + minmCoinsRec(arr, targetSum - arr[ind], ind);
        }

        int notTake = 0 + minmCoinsRec(arr, targetSum, ind - 1);
        
        return Math.min(take, notTake);
    }

    // time complexity: O(n x target)
    // space complexity: O(n x target) + O(n)
    static int minmCoinsMemo(int[] arr, int targetSum, int ind, int[][] dp) {
        
        if (targetSum == 0) return 0;

        if (ind == 0) {
            if (targetSum % arr[0] == 0) {
                return targetSum / arr[0];
            }
            return (int) 1e8;
        }

        int take = (int) 1e8;

        if (dp[ind][targetSum] != -1)
            return dp[ind][targetSum];

        if (arr[ind] <= targetSum) {
            take = 1 + minmCoinsMemo(arr, targetSum - arr[ind], ind, dp);
        }

        int notTake = 0 + minmCoinsMemo(arr, targetSum, ind - 1, dp);

        return dp[ind][targetSum] = Math.min(take, notTake);
    }

    static int minmCoinsTabu(int[] arr, int targetSum, int n, int[][] dp) {

        // base case complete
        for (int i = 0; i <= targetSum; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = (int) 1e8;
            }
        }

        for (int ind = 1; ind < n; ind++) {

            for (int tar = 0; tar <= targetSum; tar++) {

                int take = (int) 1e8;

                if (arr[ind] <= tar) {
                    take = 1 + dp[ind][tar - arr[ind]];
                }

                int notTake = 0 + dp[ind - 1][tar];

                dp[ind][tar] = Math.min(take, notTake);
            }
        }
        return dp[n - 1][targetSum];
    }

    static int minmCoinsSpOpt2Row(int[] arr, int targetSum, int n) {
        int[] prev = new int[targetSum + 1];

        // base case complete
        for (int i = 0; i <= targetSum; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];
            } else {
                prev[i] = (int) 1e8;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] current = new int[targetSum + 1];

            for (int tar = 0; tar <= targetSum; tar++) {

                int take = (int) 1e8;

                if (arr[ind] <= tar) {
                    take = 1 + current[tar - arr[ind]];
                }

                int notTake = 0 + prev[tar];

                current[tar] = Math.min(take, notTake);
            }
            prev = current;
        }
        return prev[targetSum];
    }


    static int minmCoinsSpOpt1Row(int[] arr, int targetSum, int n) {
        int[] prev = new int[targetSum + 1];

        // base case complete
        for (int i = 0; i <= targetSum; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];
            } else {
                prev[i] = (int) 1e8;
            }
        }

        for (int ind = 1; ind < n; ind++) {

            for (int tar = targetSum; tar >= 0; tar--) {

                int take = (int) 1e8;

                if (arr[ind] <= tar) {
                    take = 1 + prev[tar - arr[ind]];
                }

                int notTake = 0 + prev[tar];

                prev[tar] = Math.min(take, notTake);
            }
        }
        // System.out.println(Arrays.toString(prev));
        return prev[targetSum];
    }
}
