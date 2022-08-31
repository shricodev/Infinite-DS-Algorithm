package DynamicProgramming.Stock;

import java.util.Arrays;

public class BestTimeToBuySell2 {
    public static void main(String[] args) {
        long[] price = {1,2,3,4};
        int n = price.length;

        System.out.println(buySellOptimal(price));

        System.out.println(buySellRec(price, 0, 1));

        // for memoization
        long[][] dp = new long[n + 1][2];
        for (long[] ls : dp) {
            Arrays.fill(ls, -1);
        }
        // passing the buy and notBuy as 0 and 1 so we can use the index in the dp array.
        System.out.println(buySellMemo(price, 0, 1, dp));


        // for tabulation
        for (long[] ls : dp) {
            Arrays.fill(ls, 0);
        }
        System.out.println(buySellTabu(price, n, dp));


        // for space optimization
        System.out.println(buySellSpOpt(price, n));
    }

    // time complexity: O(n)
    // space complexity: O(1)
    // link to the problem: https://www.codingninjas.com/codestudio/problems/selling-stock_630282
    static int buySellOptimal(long[] arr) {
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    // time complexity: O(2^n)
    // space complexity: O(n)
    static long buySellRec(long[] price, int ind, int notBuyed) {

        if (ind == price.length) return 0;

        long maxProfit = 0;

        if (notBuyed == 1) {
            long buy = -price[ind] + buySellRec(price, ind + 1, 0);
            long notBuy = 0 + buySellRec(price, ind + 1, 1);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            long sell = price[ind] + buySellRec(price, ind + 1, 1);
            long notSell = 0 + buySellRec(price, ind + 1, 0);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return maxProfit;
    }

    // time complexity: O(n x 2)
    // space complexity: O(n x 2) + O(n + 2)
    static long buySellMemo(long[] price, int ind, int notBuyed, long[][] dp) {

        if (ind == price.length) return 0;

        long maxProfit = 0;

        if (dp[ind][notBuyed] != -1) return dp[ind][notBuyed];

        if (notBuyed == 1) {
            long buy = -price[ind] + buySellMemo(price, ind + 1, 0, dp);
            long notBuy = 0 + buySellMemo(price, ind + 1, 1, dp);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            long sell = price[ind] + buySellMemo(price, ind + 1, 1, dp);
            long notSell = 0 + buySellMemo(price, ind + 1, 0, dp);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return dp[ind][notBuyed] = maxProfit;
    }

    static long buySellTabu(long[] price, int n, long[][] dp) {

        dp[n][0] = dp[n][1] = 0;

        
        for (int ind = n - 1; ind >= 0; ind--) {
            
            for (int buy = 0; buy <= 1; buy++) {
                
                long maxProfit = 0;

                if (buy == 1) {
                    long bought = -price[ind] + dp[ind + 1][0];
                    long notBought = 0 + dp[ind+1][1];
                    maxProfit = Math.max(maxProfit, Math.max(bought, notBought));
        
                } else {
                    long sell = price[ind] + dp[ind+1][1];
                    long notSell = 0 + dp[ind + 1][0];
                    maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
                }
        
                dp[ind][buy] = maxProfit;
            }
        }
        return dp[0][1];

    }

    static long buySellSpOpt(long[] price, int n) {
        long[] ahead = new long[2];
        long[] curr = new long[2];

        ahead[0] = ahead[1] = 0;

        
        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {
                
                long maxProfit = 0;

                if (buy == 1) {
                    long bought = -price[ind] + ahead[0];
                    long notBought = 0 + ahead[1];
                    maxProfit = Math.max(maxProfit, Math.max(bought, notBought));
        
                } else {
                    long sell = price[ind] + ahead[1];
                    long notSell = 0 + ahead[0];
                    maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
                }
        
                curr[buy] = maxProfit;
            }
            ahead = curr;
        }
        return ahead[1];
    }
}
