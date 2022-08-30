package DynamicProgramming.OneDArr;

import java.util.Arrays;

public class MaxSumNonAdj {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int ind = arr.length - 1;
        System.out.println(maxSumRec(arr, ind));
        System.out.println(maxSumMemo(arr, ind, dp));
        System.out.println(maxSumTabu(arr, dp));
        System.out.println(maxSumTabuNoSp(arr));
    }

    // this does not involve the dp its just a rough recursion approach
    // time complexity: 0(2^n)
    // space complexity: recursion height 
    static int maxSumRec(int[] arr, int ind) {

        // if we reach the index 0 it means we have not taken the index one so if we reach the index 0 
        // then it is best to return the element itself
        if (ind == 0) return arr[ind];

        if (ind < 0) return 0; 

        int pick = arr[ind] + maxSumRec(arr, ind - 2);

        int noPick = 0 + maxSumRec(arr, ind - 1);

        return Math.max(pick, noPick);
    }

    // this is the memoization approach to solve the problem.
    // time complexity: O(n) -> recurion tree ko ek half matra execute hunxa i.e. height of the tree
    // space complexity: O(n) -> stack space + O(n) -> array size
    static int maxSumMemo(int[] arr, int ind, int[] dp) {

        // if we reach the index 0 it means we have not taken the index one so if we reach the index 0 
        // then it is best to return the element itself
        if (ind == 0) return arr[ind];

        if (ind < 0) return 0; 

        if (dp[ind] != -1) return dp[ind];

        int pick = arr[ind] + maxSumMemo(arr, ind - 2, dp);

        int noPick = 0 + maxSumMemo(arr, ind - 1, dp);

        return dp[ind] = Math.max(pick, noPick);
    }

    // time complexity: O(N)
    // space complexity: O(N)
    static int maxSumTabu(int[] arr, int[] dp) {
        
        dp[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {

            int pick = arr[i];
            
            // this is another edge case to handle.
            // is i > 1 then only we can run the dp[i - 2] or else it will throw a index out of bounds error.
            if (i > 1) pick += dp[i - 2];

            int noPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, noPick);
        }

        return dp[arr.length - 1];
    }

    // time complexity: O(N)
    // space complexity: O(1)
    static int maxSumTabuNoSp(int[] arr) {
        
        int prev = arr[0];
        int prev2 = 0;
        
        for (int i = 1; i < arr.length; i++) {

            int pick = arr[i];
            
            // this is another edge case to handle.
            // is i > 1 then only we can run the dp[i - 2] or else it will throw a index out of bounds error.
            if (i > 1) pick += prev2;

            int noPick = 0 + prev;

            int curr = Math.max(pick, noPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
