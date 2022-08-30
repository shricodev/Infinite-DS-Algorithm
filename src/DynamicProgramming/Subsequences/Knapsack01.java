package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wts = { 3, 2, 4 };
        int[] val = { 30, 40, 60 };
        int weight = 6;
        int n = wts.length;

        // for recursion
        System.out.println(stealRec(wts, val, n - 1, weight));

        // for memoization
        int dp[][] = new int[n][weight + 1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        System.out.println(stealMemo(wts, val, n - 1, weight, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }

        System.out.println(stealTabu(n, wts, val, weight, dp));

        // space optimization two row.
        System.out.println(stealSpOpt2Row(n, wts, val, weight));

        // space optimization one row
        System.out.println(stealSpOpt1Row(n, wts, val, weight));
    }
    
    // time complexity: O(exponential and not 2^n since we are not moving to the next index just by picking it once)
    static int stealRec(int[] wts, int[] val, int ind, int weight) {

        if (weight == 0) {
            return 0;
        }

        if (ind == 0) {
            if (weight >= wts[0]) {
                return val[0];
            }
            return 0;
        }

        int pick = 0;
        if (weight >= wts[ind]) {
            pick = val[ind] + stealRec(wts, val, ind - 1, weight - wts[ind]);
        }

        int notPick = stealRec(wts, val, ind - 1, weight);

        return Math.max(pick, notPick);
    }

    static int stealMemo(int[] wts, int[] val, int ind, int weight, int[][] dp) {

        if (weight == 0) {
            return 0;
        }

        if (ind == 0) {
            if (weight >= wts[0]) {
                return val[0];
            }
            return 0;
        }

        if (dp[ind][weight] != -1)
            return dp[ind][weight];

        int pick = 0;
        if (weight >= wts[ind]) {
            pick = val[ind] + stealMemo(wts, val, ind - 1, weight - wts[ind], dp);
        }

        int notPick = stealMemo(wts, val, ind - 1, weight, dp);

        return dp[ind][weight] = Math.max(pick, notPick);
    }

    static int stealTabu(int n, int[] wts, int[] val, int weight, int[][] dp) {

        for (int i = 0; i < wts.length; i++) {
            dp[i][0] = 0;
        }

        // if (weight >= wts[ind]) so running the loop from weight[0] to weight
        for (int i = wts[0]; i <= weight; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int j = 0; j <= weight; j++) {

                int pick = 0;

                if (j >= wts[ind]) {
                    pick = val[ind] + dp[ind - 1][j - wts[ind]];
                }

                int notPick = 0 + dp[ind - 1][j];

                dp[ind][j] = Math.max(pick, notPick);

            }
        }
        return dp[n - 1][weight];
    }

    static int stealSpOpt2Row(int n, int[] wts, int[] val, int weight) {
        int[] prev = new int[weight + 1];

        prev[0] = 0;

        for (int i = wts[0]; i <= weight; i++) {
            prev[i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            int[] current = new int[weight + 1];

            for (int j = 0; j <= weight; j++) {

                int pick = 0;

                if (j >= wts[ind]) {
                    pick = val[ind] + prev[j - wts[ind]];
                }

                int notPick = 0 + prev[j];

                current[j] = Math.max(pick, notPick);

            }
            prev = current;
        }
        return prev[weight];
    }


    static int stealSpOpt1Row(int n, int[] wts, int[] val, int weight) {
        int[] prev = new int[weight + 1];

        prev[0] = 0;

        for (int i = wts[0]; i <= weight; i++) {
            prev[i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int j = weight; j >= 0; j--) {

                int pick = 0;

                if (j >= wts[ind]) {
                    pick = val[ind] + prev[j - wts[ind]];
                }

                int notPick = 0 + prev[j];

                prev[j] = Math.max(pick, notPick);
            }
        }
        return prev[weight];
    }

}