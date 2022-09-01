package DynamicProgramming.Stock;

import java.util.Arrays;

public class BestTimeToBuySell3and4 {
    public static void main(String[] args) {
        long[] price = { 9, 6, 10, 18, 15, 14, 14, 5, 16, 12 };
        int n = price.length;
        int k = 2;

        System.out.println(buySellRec(price, 0, 1, k));

        // for memoization
        long[][][] dp = new long[n + 1][2][k + 1];
        for (long[][] ls2 : dp) {
            for (long[] ls : ls2) {
                Arrays.fill(ls, -1);
            }
        }
        // passing the buy and notBuy as 0 and 1 so we can use the index in the dp
        // array.
        System.out.println(buySellMemo(price, 0, 1, dp, k));

        // for tabulation
        for (long[][] ls2 : dp) {
            for (long[] ls : ls2) {
                Arrays.fill(ls, 0);
            }
        }
        System.out.println(buySellTabu(price, dp, k, n));

        // for space optimization
        System.out.println(buySellSpOpt(price, k, n));

        // method two
        System.out.println(buySellWay2(price, 0, 0, k));
    }

    // this is another way to solve the problem. memoization for this require only a
    // 2d dp.
    // do this mehtod memoization, tabulation, space optimization in future. Its jsut the same approach
    static long buySellWay2(long[] price, int ind, int transNo, int k) {

        if (transNo == k * 2)
            return 0;

        if (ind == price.length)
            return 0;

        long maxProfit = 0;
        // visualization: B S B S
        // index: 0 1 2 3
        // this means the transaction is a buy.
        if (transNo % 2 == 0) {
            long buy = -price[ind] + buySellWay2(price, ind + 1, transNo + 1, k);
            long notBuy = 0 + buySellWay2(price, ind + 1, transNo, k);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));
        } else {
            // this means the transaction is a sell.
            long sell = price[ind] + buySellWay2(price, ind + 1, transNo + 1, k);
            long notSell = 0 + buySellWay2(price, ind + 1, transNo, k);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }
        return maxProfit;
    }

    // time complexity: O(exponential)
    // space complexity: O(n)
    // link:
    // https://www.codingninjas.com/codestudio/problems/buy-and-sell-stock_1071012
    static long buySellRec(long[] price, int ind, int notBuyed, int k) {

        if (k == 0)
            return 0;

        if (ind == price.length)
            return 0;

        long maxProfit = 0;

        if (notBuyed == 1) {
            long buy = -price[ind] + buySellRec(price, ind + 1, 0, k);
            long notBuy = 0 + buySellRec(price, ind + 1, 1, k);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            long sell = price[ind] + buySellRec(price, ind + 1, 1, k - 1);
            long notSell = 0 + buySellRec(price, ind + 1, 0, k);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return maxProfit;
    }

    // time complexity: O(n x 2 x 3)
    // space complexity: O(n x 2 x 3) + O(n)

    // this also gives tle in code studio
    static long buySellMemo(long[] price, int ind, int notBuyed, long[][][] dp, int k) {

        if (k == 0)
            return 0;

        if (ind == price.length)
            return 0;

        long maxProfit = 0;

        if (dp[ind][notBuyed][k] != -1)
            return dp[ind][notBuyed][k];

        if (notBuyed == 1) {
            // we will not decrease the k here as it needs to be a complete transaction to
            // reduce the k.
            long buy = -price[ind] + buySellMemo(price, ind + 1, 0, dp, k);
            long notBuy = 0 + buySellMemo(price, ind + 1, 1, dp, k);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            long sell = price[ind] + buySellMemo(price, ind + 1, 1, dp, k - 1);
            long notSell = 0 + buySellMemo(price, ind + 1, 0, dp, k);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return dp[ind][notBuyed][k] = maxProfit;
    }

    // time complexity: O(n x 2 x 3)
    // space complexity: O(n x 2 x 3)
    // this gives tle in code studio. even after removing the base case loop
    static long buySellTabu(long[] price, long[][][] dp, int k, int n) {

        // these two base cases make no sense since the array is alreedy filled with
        // zero, but for understanding i am going to write the base case.
        for (int ind = 0; ind < n; ind++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[ind][buy][0] = 0;
            }
        }

        for (int buy = 0; buy <= 1; buy++) {
            for (int tempK = 0; tempK <= k; tempK++) {
                dp[n][buy][tempK] = 0;
            }
        }

        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                // the tempK value zero is already assigned in the base case.
                for (int tempK = 1; tempK <= k; tempK++) {

                    long maxProfit = 0;

                    if (buy == 1) {
                        // we will not decrease the k here as it needs to be a complete transaction to
                        // reduce the k.
                        dp[ind][buy][tempK] = Math.max(maxProfit,
                                Math.max(-price[ind] + dp[ind + 1][0][tempK], 0 + dp[ind + 1][1][tempK]));

                    } else {
                        dp[ind][buy][tempK] = Math.max(maxProfit,
                                Math.max(price[ind] + dp[ind + 1][1][tempK - 1], 0 + dp[ind + 1][0][tempK]));
                    }
                }
            }
        }
        return dp[0][1][k];
    }

    // time complexity: O(n x 2 x 3)
    // space complexity: O(1)
    static long buySellSpOpt(long[] price, int k, int n) {

        long[][] ahead = new long[2][k + 1];
        long[][] curr = new long[2][k + 1];

        // these two base cases make no sense since the array is alreedy filled with
        // zero, but for understanding i am going to write the base case.
        for (int ind = 0; ind < n; ind++) {
            for (int buy = 0; buy <= 1; buy++) {
                ahead[buy][0] = 0;
            }
        }

        for (int buy = 0; buy <= 1; buy++) {
            for (int tempK = 0; tempK <= k; tempK++) {
                ahead[buy][tempK] = 0;
            }
        }

        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                // the tempK value zero is already assigned in the base case.
                for (int tempK = 1; tempK <= k; tempK++) {

                    long maxProfit = 0;

                    if (buy == 1) {
                        // we will not decrease the k here as it needs to be a complete transaction to
                        // reduce the k.
                        curr[buy][tempK] = Math.max(maxProfit,
                                Math.max(-price[ind] + ahead[0][tempK], 0 + ahead[1][tempK]));

                    } else {
                        curr[buy][tempK] = Math.max(maxProfit,
                                Math.max(price[ind] + ahead[1][tempK - 1], 0 + ahead[0][tempK]));
                    }
                }
            }
            ahead = curr;
        }
        return ahead[1][k];
    }

}
