package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CuttingRod {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 8, 10 };
        int n = arr.length;
        System.out.println(cutRodRec(n, arr, n - 1));

        // for memoization
        int[][] dp = new int[n][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(cutRodMemo(n, arr, n - 1, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(cutRodTabu(n, arr, dp));

        // for space optimizaiton
        System.out.println(cutRodSpOpt(n, arr));

        // for one row space optimization
        System.out.println(cutRodSpOpt1Row(n, arr));
    }

    // time complexity: O(exponential)
    // space complexity: O(target)
    static int cutRodRec(int n, int[] arr, int ind) {

        if (ind == 0) {
            return n * arr[0];
        }

        int notTake = 0 + cutRodRec(n, arr, ind - 1);

        int rodLength = ind + 1;
        int take = (int) -1e8;

        if (rodLength <= n) {
            take = arr[ind] + cutRodRec(n - rodLength, arr, ind);
        }

        return Math.max(notTake, take);
    }

    // time complexity: O(n * n)
    // space complexity: O(n x n) + O(target)
    static int cutRodMemo(int n, int[] arr, int ind, int[][] dp) {

        if (ind == 0) {
            return n * arr[0];
        }

        if (dp[ind][n] != -1)
            return dp[ind][n];

        int notTake = 0 + cutRodMemo(n, arr, ind - 1, dp);

        int rodLength = ind + 1;
        int take = (int) -1e8;

        if (rodLength <= n) {
            take = arr[ind] + cutRodMemo(n - rodLength, arr, ind, dp);
        }

        return dp[ind][n] = Math.max(notTake, take);
    }

    // time complexity; O(n x n)
    // space complexity: O(n x n)
    static int cutRodTabu(int n, int[] arr, int[][] dp) {

        for (int N = 0; N <= n; N++) {
            dp[0][N] = N * arr[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int N = 0; N <= n; N++) {
                int notTake = 0 + dp[ind - 1][N];

                int rodLength = ind + 1;
                int take = (int) -1e8;

                if (rodLength <= N) {
                    take = arr[ind] + dp[ind][N - rodLength];
                }

                dp[ind][N] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][n];
    }

    static int cutRodSpOpt(int n, int[] arr) {

        int[] prev = new int[n + 1];

        for (int N = 0; N <= n; N++) {
            prev[N] = N * arr[0];
        }

        for (int ind = 1; ind < n; ind++) {

            int[] curr = new int[n + 1];

            for (int N = 0; N <= n; N++) {
                int notTake = 0 + prev[N];

                int rodLength = ind + 1;
                int take = (int) -1e8;

                if (rodLength <= N) {
                    take = arr[ind] + curr[N - rodLength];
                }

                curr[N] = Math.max(notTake, take);
            }
            prev = curr;
        }
        return prev[n];
    }

    static int cutRodSpOpt1Row(int n, int[] arr) {

        int[] prev = new int[n + 1];

        for (int N = 0; N <= n; N++) {
            prev[N] = N * arr[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int N = 0; N <= n; N++) {
                int notTake = 0 + prev[N];

                int rodLength = ind + 1;
                int take = (int) -1e8;

                if (rodLength <= N) {
                    take = arr[ind] + prev[N - rodLength];
                }

                prev[N] = Math.max(notTake, take);
            }
        }
        return prev[n];
    }
}