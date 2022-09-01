package DynamicProgramming.Stock;

public class BestTimeToBuySell6 {
    public static void main(String[] args) {
        long[] price = {1,2,3,4};
        int fee = 2;

        System.out.println(buySellRec(price, 0, 1, fee));
    }

    // this is the same logic as the other dp on stocks so not doing the rest memo, and tabu.
    static long buySellRec(long[] price, int ind, int notBuyed, int fee) {

        if (ind == price.length) return 0;

        long maxProfit = 0;

        if (notBuyed == 1) {
            long buy = -price[ind] + buySellRec(price, ind + 1, 0, fee);
            long notBuy = 0 + buySellRec(price, ind + 1, 1, fee);
            maxProfit = Math.max(maxProfit, Math.max(buy, notBuy));

        } else {
            long sell = price[ind] - fee + buySellRec(price, ind + 1, 1, fee);
            long notSell = 0 + buySellRec(price, ind + 1, 0, fee);
            maxProfit = Math.max(maxProfit, Math.max(sell, notSell));
        }

        return maxProfit;
    }
}
