package DynamicProgramming;

import java.util.Arrays;

public class FibUsingTabulation {
    public static void main(String[] args) {
        int n = 10;
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(fibDP(n, dp));

        System.out.println(fibDPNoSpace(n));
    }

    // no recursion stack space since we are not using recusion as in the memoization technique
    // the more optimized solution to the problem using O(1) space complexity.
    // time complexity: O(N)
    // Space complexity: O(1)
    private static int fibDPNoSpace(int n) {
        int prev2 = 0;
        int prev = 1;
        int currentI = 0;
        
        for (int i = 2; i <= n; i++) {
            currentI = prev2 + prev;
            prev2 = prev;
            prev = currentI;
        }
        return prev;
    }

    // time complexity: O(N)
    // space complexity: O(N) -> for storing the value
    private static int fibDP(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }



}
