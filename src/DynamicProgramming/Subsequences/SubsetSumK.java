package DynamicProgramming.Subsequences;


public class SubsetSumK {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1 };
        int k = 4;
        int n = arr.length;
        System.out.println(checkSubsetRec(n, n - 1, arr, k));

        // for memoization
        boolean[][] dp = new boolean[(int) 1e3 + 1][(int) 1e3 + 1];
        System.out.println(checkSubsetMemo(n, n - 1, arr, dp, k));
    
        // for tabulation
        System.out.println(checkSubsetTabu(n, arr, dp, k));

        // space optimization
        System.out.println(checkSubsetSpOpt(n, arr, k));
    }

    // check if there is even a single subset, if there is then return true else
    // false;
    // time compleaxity: O(2^n)
    // space complexity: O(n) -> stack space
    static boolean checkSubsetRec(int n, int ind, int[] arr, int target) {

        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            if (target - arr[0] == 0)
                return true;

            return false;
        }

        // exclude
        boolean notTake = checkSubsetRec(n, ind - 1, arr, target);

        // include.
        boolean take = false;

        if (target >= arr[ind])
            take = checkSubsetRec(n, ind - 1, arr, target - arr[ind]);

        return (notTake || take);
    }

    // time complexity: O(n X target)
    // space complexity: O(n) + O(n X target)
    static boolean checkSubsetMemo(int n, int ind, int[] arr, boolean[][] dp, int target) {

        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            if (target == arr[0])
                return true;

            return false;
        }

        if (dp[ind][target] != false)
            return dp[ind][target];

        // exclude
        boolean notTake = checkSubsetMemo(n, ind - 1, arr, dp, target);

        // include.
        boolean take = false;

        if (target >= arr[ind])
            take = checkSubsetMemo(n, ind - 1, arr, dp, target - arr[ind]);

        return dp[ind][target] = (notTake || take);
    }

    static boolean checkSubsetTabu(int n, int[] arr, boolean[][] dp, int k) {

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
        return dp[n - 1][k];
    }

    // time complexity: O(n x target)
    // space complexity: O(target)
    static boolean checkSubsetSpOpt(int n, int[] arr, int k) {
        boolean[] prev = new boolean[k+1];
        
        // first base case
        prev[0] = true;
        
        // second base case.
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        
        for (int ind = 1; ind < n; ind++) {
            boolean[] current = new boolean[k+1];
            current[0] = true;
            
            for (int target = 1; target <= k; target++) {
                // exclude
                boolean notTake = prev[target];

                // include.
                boolean take = false;

                if (target >= arr[ind])
                    take = prev[target - arr[ind]];

                current[target] = (notTake || take);
            }
            prev = current;
        }
        return prev[k];
    }
}
