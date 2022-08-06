package DynamicProgramming;

import java.util.Arrays;

public class FibUsingMemoization {

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibDP(n, dp));
    }

    // time complexity: O(N)
    // space complexity: O(N) -> recursion stack space + O(N) for storing the data in the array.
    static int fibDP(int n, int[] dp) {
        // base case
        if (n <= 1) return n;

        // this is the step which is going to reduce the no of recursion we do to solve the qn
        if (dp[n] != -1) return dp[n];

        // so if the above if condition is not executed then add the value of the sub problem in the array.  
        return dp[n] = fibDP(n - 1, dp) + fibDP(n - 2, dp);
    }
}
