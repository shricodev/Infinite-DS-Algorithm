package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;

public class LongIncSubseq {
    public static void main(String[] args) {
        int[] arr = { 5, 8, 3, 7, 9, 1 };
        int n = arr.length;
        int prevTakeInd = -1;
        System.out.println(lisRec(arr, 0, prevTakeInd, n));

        // for memoization
        // the n + 1 in index for tabulation.
        int[][] dp = new int[n + 1][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(lisMemo(arr, 0, prevTakeInd, n, dp));
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(lisTabu(arr, n, dp));

        // space optimization
        System.out.println(lisSpOpt(arr, n));

        // algorithmic approach
        System.out.println(lisAlgorithmic(arr, n));

        // optimized approach
        System.out.println(lisOptimal(n, arr));

    }

    // ! NOTE: 
    // ! I am not able to visualize printing of the lis properly in the dp 42 using the hash array method.
    // ! make sure to have a look in the future.

    // this method finds the lowerbound index of the elemnt.
    // binary search code.
    static int lower_bound(ArrayList<Integer> array, int key) {
        // Initialize starting index and
        // ending index
        int low = 0, high = array.size();
        int mid;

        // Till high does not crosses low
        while (low < high) {

            // Find the index of the middle element
            mid = low + (high - low) / 2;

            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array.get(mid)) {
                high = mid;
            }

            // If key is greater than array[mid],
            // then find in right subarray
            else {

                low = mid + 1;
            }
        }

        if (low < array.size() && array.get(low) < key) {
            low++;
        }

        // Returning the lower_bound index
        return low;
    }

    // time complexity: O(NlogN)
    // space complexity: O(N)
    // * NOTE THE ANS ARR IS NOT THE ACTUAL LIS.
    static int lisOptimal(int n, int[] arr) {

        if (n == 0)
            return 0;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
            } else {
                int indOfLowerBound = lower_bound(ans, arr[i]);
                // this method swaps the value of the index with the given value.
                ans.set(indOfLowerBound, arr[i]);
            }
        }
        return ans.size();
    }

    // this is the more intuitive code of the lis len print .
    // time complexity: O(n^2)
    static int lisAlgorithmic(int arr[], int n) {

        int[] dp = new int[n];
        // since for each individual elemnt the smallest lis is 1.
        Arrays.fill(dp, 1);
        int maxi = 1;
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

        return maxi;
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
    // * TODO: take a look at the code in the future.
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

    static int lisSpOpt(int[] arr, int n) {
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        // not needed.
        for (int prev = 0; prev <= n; prev++) {
            next[prev] = 0;
        }

        for (int ind = n - 1; ind >= 0; ind--) {

            for (int prev = ind - 1; prev >= -1; prev--) {

                int notTake = 0 + next[prev + 1];
                int take = 0;

                if (prev == -1 || arr[ind] > arr[prev]) {
                    take = 1 + next[ind + 1];
                }

                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }

}
