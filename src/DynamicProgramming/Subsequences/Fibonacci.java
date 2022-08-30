package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // for memoization
        System.out.println(fibDPMemo(n, dp));
        
        // for tabulation
        Arrays.fill(dp, 0);
        System.out.println(fibDPTabu(n, dp));

        // for space optimization
        System.out.println(fibDPNoSpace(n));
    }

    // time complexity: O(N)
    // space complexity: O(N) -> recursion stack space + O(N) for storing the data in the array.
    // top down approach
    static int fibDPMemo(int n, int[] dp) {
        // base case
        if (n <= 1) return n;

        // this is the step which is going to reduce the no of recursion we do to solve the qn
        if (dp[n] != -1) return dp[n];

        // so if the above if condition is not executed then add the value of the sub problem in the array.  
        return dp[n] = fibDPMemo(n - 1, dp) + fibDPMemo(n - 2, dp);
    }

    private static int fibDPTabu(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
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
}
