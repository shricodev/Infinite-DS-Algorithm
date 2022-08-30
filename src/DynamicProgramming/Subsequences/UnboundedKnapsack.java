package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wts = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int weight = 10;
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

    // time complexity: O(exponential and not 2^n since we are not moving to the
    // next index just by picking it once)
    // space complexity: O(weight assuming the worst case as val is 1)
    static int stealRec(int[] wts, int[] val, int ind, int weight) {

        if (weight == 0) {
            return 0;
        }

        if (ind == 0) {
            if (weight >= wts[0]) {

                return ((int) (weight / wts[0])) * val[0];
            }
            return 0;
        }

        int pick = 0;
        if (weight >= wts[ind]) {
            pick = val[ind] + stealRec(wts, val, ind, weight - wts[ind]);
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
                return ((int) (weight / wts[0])) * val[0];
            }
            return 0;
        }

        if (dp[ind][weight] != -1)
            return dp[ind][weight];

        int pick = 0;
        if (weight >= wts[ind]) {
            pick = val[ind] + stealMemo(wts, val, ind, weight - wts[ind], dp);
        }

        int notPick = stealMemo(wts, val, ind - 1, weight, dp);

        return dp[ind][weight] = Math.max(pick, notPick);
    }

    static int stealTabu(int n, int[] wts, int[] val, int weight, int[][] dp) {

        for (int i = 0; i < wts.length; i++) {
            dp[i][0] = 0;
        }

        // if (weight >= wts[ind]) so running the loop from weight[0] to weight
        for (int W = wts[0]; W <= weight; W++) {
            dp[0][W] = ((int) (W / wts[0])) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int W = 0; W <= weight; W++) {

                int pick = 0;

                if (W >= wts[ind]) {
                    pick = val[ind] + dp[ind][W - wts[ind]];
                }

                int notPick = 0 + dp[ind - 1][W];

                dp[ind][W] = Math.max(pick, notPick);

            }
        }
        return dp[n - 1][weight];
    }

    static int stealSpOpt2Row(int n, int[] wts, int[] val, int weight) {
        int[] prev = new int[weight + 1];

        prev[0] = 0;

        for (int W = wts[0]; W <= weight; W++) {
            prev[W] = ((int) (W / wts[0])) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            int[] current = new int[weight + 1];

            for (int W = 0; W <= weight; W++) {

                int pick = 0;

                if (W >= wts[ind]) {
                    pick = val[ind] + current[W - wts[ind]];
                }

                int notPick = 0 + prev[W];

                current[W] = Math.max(pick, notPick);

            }
            prev = current;
        }
        return prev[weight];
    }

    /*
     * ? found a beautiful comment for explanation of the weight from 0 -> w
     * in 19 , we were no in the same index after taking a particular element ,
     * consider the following statement of taking a particular element of dp 19 and
     * this video :-
     * dp 19:
     * take = value[ind]+help(ind-1,w-weight[ind],weight,value,dp);
     * dp 23:
     * take = profit[ind]+help(ind,w-weight[ind],profit,weight,dp);
     * 
     * in case of dp 19 , we are going to ind-1 , and for that , in our tabulation
     * code , we will use prev array , in case of dp 23 we are in same index , and
     * in our tabulation code , we will use curr array , if we are using curr , we
     * do not need to worry about prev[w-weight[ind]], that is why forward iteration
     * will work here .
     */

    //! NOTE: remember when there is infinite supply, then run the
    //! inner loop from 0 to weight. when there is not use the ineer loop from weight to
    //! 0
    static int stealSpOpt1Row(int n, int[] wts, int[] val, int weight) {
        int[] prev = new int[weight + 1];

        prev[0] = 0;

        for (int W = wts[0]; W <= weight; W++) {
            prev[W] = ((int) (W / wts[0])) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int W = 0; W <= weight; W++) {

                int pick = 0;

                if (W >= wts[ind]) {
                    pick = val[ind] + prev[W - wts[ind]];
                }

                int notPick = 0 + prev[W];

                prev[W] = Math.max(pick, notPick);
            }
        }
        return prev[weight];
    }

}