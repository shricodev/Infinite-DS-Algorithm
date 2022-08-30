package DynamicProgramming.Subsequences;

public class DiffOfSubsetSumMin {
    public static void main(String[] args) {
        int[] arr = { 1,3,2,5,6 };
        int target = 7;
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        System.out.println(checkSubsetTabu(arr.length, arr, dp, target));
    }

    // link: https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
    static int checkSubsetTabu(int n, int[] arr, boolean[][] dp, int k) {

        // first base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // second base case.
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            
            for (int target = 1; target <= k; target++) {
                // exclude
                boolean notTake = dp[ind - 1][target];

                // include.
                boolean take = false;

                if (target >= arr[ind])
                    take = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = (notTake || take);
            }
        }

        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        /*
         * till this line the code of the subsetSumK tabulation and this is same.
         * the only change is done in the below code.
         */
        
        int min = (int) 1e8;
        for (int i = 0; i <= k; i++) {
            // if in a index the sum is possible.
            if (dp[n-1][i] == true) {
                int sub1 = i;
                // for every subset 1 total sum - i is the subset2.
                int sub2 = totalSum - i;
                // returning the min of the difference of the subset sum 1 and subset sum 2. 
                min = Math.min(min, Math.abs(sub2 - sub1));
            }
        }
        return min;
    }
}
