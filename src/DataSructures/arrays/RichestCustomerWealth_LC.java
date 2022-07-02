package DataSructures.Arrays;

// link: https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth_LC {
    public static void main(String[] args) {
        // here every row sum indicates the wealth of the individual.
        int[][] arr = {
            {1, 2, 3},
            {1, 3, 4},
            {21, 32, 43}
        };
        System.out.println(compareWealth(arr));
    }

    static int compareWealth(int[][] arr) {
        int maxWealth = 0;

        for (int row = 0; row < arr.length; row++) {
            // it holds the sum of every row.
            int rowSum = 0;

            for (int col = 0; col < arr[row].length; col++) {
                rowSum += arr[row][col];
            }

            // at last if the rowSum is greater than the maxWealth then only update the maxWealth.
            if (rowSum > maxWealth) {
                maxWealth = rowSum;
            }
        }
        return maxWealth;
    }
}