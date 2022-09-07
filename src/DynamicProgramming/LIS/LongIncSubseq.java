package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongIncSubseq {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 11, 1, 16, 8 };
        int n = arr.length;
        int prevTakeInd = -1;
        System.out.println(lisRec(arr, 0, prevTakeInd, n));

        // for memoization
        // the n + 1 in index for tabulation.
        int[][] dp = new int[n+1][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(lisMemo(arr, 0, prevTakeInd, n, dp));
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(lisTabu(arr, n, dp));

    }

    // time complexity: O(2^n)
    // space complexity: O(n)
    static int lisRec(int[] arr, int ind, int prevTakeInd, int n) {

        if (ind == n) {
            return 0;
        }

        int notTake = 0 + lisRec(arr, ind + 1, prevTakeInd, n);
        int take = 0;

        if (prevTakeInd == -1 || arr[ind] > arr[prevTakeInd]) {
            take = 1 + lisRec(arr, ind + 1, ind, n);
        }

        return Math.max(take, notTake);
    }

    // time complexity: O(n x n)
    // space complexity: O(n) + O(n x n)
    // this code passes leetcode but not codestudio because the constraints of the
    // codestudio is quiet high.
    static int lisMemo(int[] arr, int ind, int prevTakeInd, int n, int[][] dp) {

        if (ind == n) {
            return 0;
        }

        if (dp[ind][prevTakeInd + 1] != -1)
            return dp[ind][prevTakeInd + 1];

        int notTake = 0 + lisMemo(arr, ind + 1, prevTakeInd, n, dp);
        int take = 0;

        if (prevTakeInd == -1 || arr[ind] > arr[prevTakeInd]) {
            take = 1 + lisMemo(arr, ind + 1, ind, n, dp);
        }

        return dp[ind][prevTakeInd + 1] = Math.max(take, notTake);
    }

    // not completely understood the concept of this code. 
    // * TODO: take a look at the code in  the future.
    static int lisTabu(int[] arr, int n, int[][] dp) {

        // not needed.
        for (int prev = 0; prev <= n; prev++) {
            dp[n][prev] = 0;
        }

        for (int ind = n - 1; ind >= 0; ind--) {

            for (int prev = ind - 1; prev >= -1; prev--) {

                int notTake = 0 + dp[ind + 1][prev + 1];
                int take = 0;

                if (prev == -1 || arr[ind] > arr[prev]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

}
