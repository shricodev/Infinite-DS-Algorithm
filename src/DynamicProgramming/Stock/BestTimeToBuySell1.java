package DynamicProgramming.Stock;

public class BestTimeToBuySell1 {
    public static void main(String[] args) {
        int[] arr = {17, 20, 11, 9, 12, 6};
        System.out.println(buySell(arr));
    }

    // link: https://www.codingninjas.com/codestudio/problems/stocks-are-profitable_893405
    static int buySell(int[] arr) {
        int minPrice = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
            minPrice = Math.min(minPrice, arr[i]);
        }
        return maxProfit;
    }
}