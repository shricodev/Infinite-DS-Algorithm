package DynamicProgramming.LIS;

import java.util.Arrays;

public class PrintLis {
    public static void main(String[] args) {
        int[] arr = { 1, 10, 12, 4, 3, 23 };
        int n = arr.length;
        helper(arr, n);
    }

    static void helper(int[] arr, int n) {
        int[] dp = lisAlgorithmic(arr, n);
        int dpLen = dp.length;

        int maxi = 0;
        for (int i = 0; i < dpLen; i++) {
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        int ind = dp.length - 1;
        printLis(dp, maxi, dpLen, ind, arr);

    }

    static int[] lisAlgorithmic(int arr[], int n) {

        int[] dp = new int[n];
        // since for each individual elemnt the smallest lis is 1.
        Arrays.fill(dp, 1);
        int maxi = 0;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {

                if (arr[prev] < arr[ind]) {
                    // if the previous index of the array is smaller thatn the i then the dp[i] ans
                    // should be the 1 + dp[prev]
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }

        return dp;
    }

    static void printLis(int[] dp, int maxi, int n, int ind, int[] arr) {

        if (maxi == 0)
            return;

        if (dp[ind] == maxi) {
            printLis(dp, maxi - 1, n, ind - 1, arr);
            System.out.println(arr[ind] + " ");

        } else {
            printLis(dp, maxi, n, ind - 1, arr);
        }
    }
}
