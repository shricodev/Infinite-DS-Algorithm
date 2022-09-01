package DynamicProgramming.Stock;

import java.util.Arrays;

public class BestTimeToBuySell5 {
    public static void main(String[] args) {

        int[] prices = {1,2,3,0,2};
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        
        System.out.println(buySellRec(prices, 0, 1));
        
        for (int[] ls : dp) {
            Arrays.fill(ls, -1);
        }

        System.out.println(buySellMemo(prices, 0, 1, dp));
        
        for (int[] ls : dp) {
            Arrays.fill(ls, 0);
        }
        System.out.println(buySellTabu(prices, n, dp));
    }

    // time complexity: O(2^n)
    // space complexity: O(n)
    static int buySellRec(int[] price, int ind, int notBuyed) {

        // since there is ind + 2 condition so we need to handle case when the ind is n - 1
        if (ind >= price.length) return 0;

        int maxProfit = 0;

        if (notBuyed == 1) {
            int buy = -price[ind] + buySellRec(price, ind + 1, 0);
            int notBuy = 0 + buySellRec(price, ind + 1, 1);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            int sell = price[ind] + buySellRec(price, ind + 2, 1);
            int notSell = 0 + buySellRec(price, ind + 1, 0);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return maxProfit;
    }

    // time complexity: O(n x 2)
    // space complexity: O(n x 2) + O(n + 2)
    static int buySellMemo(int[] price, int ind, int notBuyed, int[][] dp) {

        if (ind >= price.length) return 0;

        int maxProfit = 0;

        if (dp[ind][notBuyed] != -1) return dp[ind][notBuyed];

        if (notBuyed == 1) {
            int buy = -price[ind] + buySellMemo(price, ind + 1, 0, dp);
            int notBuy = 0 + buySellMemo(price, ind + 1, 1, dp);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            int sell = price[ind] + buySellMemo(price, ind + 2, 1, dp);
            int notSell = 0 + buySellMemo(price, ind + 1, 0, dp);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return dp[ind][notBuyed] = maxProfit;
    }

    static int buySellTabu(int[] price, int n, int[][] dp) {

        for (int ind = n - 1; ind >= 0; ind--) {
            
            for (int buy = 0; buy <= 1; buy++) {
                
                int maxProfit = 0;

                if (buy == 1) {
                    int bought = -price[ind] + dp[ind + 1][0];
                    int notBought = 0 + dp[ind+1][1];
                    maxProfit = Math.max(maxProfit, Math.max(bought, notBought));
        
                } else {
                    int sell = price[ind] + dp[ind+2][1];
                    int notSell = 0 + dp[ind + 1][0];
                    maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
                }
        
                dp[ind][buy] = maxProfit;
            }
        }
        return dp[0][1];

    }
}
