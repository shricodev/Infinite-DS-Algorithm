package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CountSubset {
    public static void main(String[] args) {
        int[] arr = {};
        // int[] arr = {1,2,2,3}
        int n = arr.length;
        int sum = 3;
        // int target = 5;
        
        // for recurison
        // System.out.println(countWithKRec(arr, n - 1, sum));

        int dp[][] = new int[n][sum + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        
        // for memoization with zero.
        // System.out.println(countWithZeroMemo(arr, n - 1, sum, dp));
        
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // for memoization
        System.out.println(countWithKMemo(arr, n - 1, sum, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(countWithKTabu(n, sum, arr, dp));

        // for space optimization
        System.out.println(countWithKSpOpt(n, sum, arr));
    }

    // now the constraints have been changed in the site itself, so the code with non zero element do not work.
    // this will handle when the array has zero also in it.
    static int countWithZeroMemo(int[] arr, int ind, int target, int[][] dp) {

        // out of bounds base case;
        if (ind == 0) {
            // if the target is zero in the first index then we have two option, either to
            // take or not take
            if (target == 0 && arr[0] == 0)
                return 2;

            // if we are in the first index and the target is zero then we can only not
            // take.
            if (target == 0 || target == arr[0])
                return 1;

            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int pick = 0;

        if (arr[ind] <= target) {
            pick = countWithZeroMemo(arr, ind - 1, target - arr[ind], dp);
        }

        int notPick = countWithZeroMemo(arr, ind - 1, target, dp);

        return dp[ind][target] = pick + notPick;
    }

    // link:
    // https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
    // time complexity: O(2^n)
    // space complexity: O(n)

    //TODO: only 11/12 of the test case are passing, make sure to have a look in the future.
    static int countWithKRec(int[] arr, int ind, int sum) {

        // if at any index the target is 0, then just return 1;
        if (sum == 0)
            return 1;
            
        // out of bounds base case;
        if (ind == 0) {
            if (sum == arr[0]) return 1;
            return 0;
        }
            
        int notPick = countWithKRec(arr, ind - 1, sum);
        int pick = 0;

        if (arr[ind] <= sum) {
            pick = countWithKRec(arr, ind - 1, sum - arr[ind]);
        }

        return pick + notPick;
    }

    // time complexity: O(nXtarget)
    // space complexity: O(n) + O(nXtarget)
    //TODO: only 11/12 of the test case are passing, make sure to have a look in the future.
    static int countWithKMemo(int[] arr, int ind, int target, int[][] dp) {

        // if at any index the target is 0, then just return 1;
        if (target == 0)
            return 1;

        // out of bounds base case;
        if (ind == 0) {
            if (target == arr[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int pick = 0;

        if (arr[ind] <= target) {
            pick = countWithKMemo(arr, ind - 1, target - arr[ind], dp);
        }

        int notPick = countWithKMemo(arr, ind - 1, target, dp);

        return dp[ind][target] = pick + notPick;
    }

    // time complexity: O(nXtarget)
    // space complexity: O(nXtarget)
    static int countWithKTabu(int n, int target, int[] arr, int[][] dp) {

        // this is the target = 0, base case.
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // out of bounds base case.
        if (arr[0] <= target)
            dp[0][arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {

            for (int sum = 0; sum <= target; sum++) {

                int pick = 0;

                if (arr[ind] <= sum) {
                    pick = dp[ind - 1][sum - arr[ind]];
                }

                int notPick = dp[ind - 1][sum];

                dp[ind][sum] = pick + notPick;

            }
        }
        return dp[n - 1][target];
    }

    // time complexity: O(nXtarget)
    // space complexity: O(target)
    static int countWithKSpOpt(int n, int target, int[] arr) {

        int[] prev = new int[target + 1];

        // this is the target = 0, base case.
        prev[0] = 1;

        // out of bounds base case.
        if (arr[0] <= target)
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {

            int[] current = new int[target + 1];

            for (int sum = 0; sum <= target; sum++) {

                int pick = 0;

                if (arr[ind] <= sum) {
                    pick = prev[sum - arr[ind]];
                }

                int notPick = prev[sum];

                current[sum] = pick + notPick;

            }
            prev = current;
        }
        return prev[target];

    }

}
