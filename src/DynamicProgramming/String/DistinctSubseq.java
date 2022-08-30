package DynamicProgramming.String;

import java.util.Arrays;

public class DistinctSubseq {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int n = s1.length();
        int m = s2.length();
        System.out.println(countSubRec(s1, s2, n - 1, m - 1));

        // for memoization
        int[][] dp = new int[n + 1][m + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(countSubMemo(s1, s2, n - 1, m - 1, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(countSubTabu(s1, s2, n, m, dp));

        // for space optimization
        System.out.println(countSubSpOpt(s1, s2, n, m));

        // for one d space optimization
        System.out.println(countSub1Arr(s1, s2, n, m));
    }

    // time complexity: O(exponential) -> O(2^n * 2^m)
    // space complexity: O(n + m)

    // link: https://leetcode.com/problems/distinct-subsequences/
    // LEETCODE: hard
    static int countSubRec(String s1, String s2, int ind1, int ind2) {

        if (ind2 < 0)
            return 1;

        if (ind1 < 0)
            return 0;

        // optimization technique.
        if (ind1 < ind2)
            return 0;

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return (countSubRec(s1, s2, ind1 - 1, ind2 - 1) + countSubRec(s1, s2, ind1 - 1, ind2));
        } else {
            return countSubRec(s1, s2, ind1 - 1, ind2);
        }
    }

    // time complexity: O(n x m)
    // space complexity: O(n x m) + O(n + m)
    static int countSubMemo(String s1, String s2, int ind1, int ind2, int dp[][]) {

        if (ind2 < 0)
            return 1;

        if (ind1 < 0)
            return 0;

        // optimization technique.
        if (ind1 < ind2)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = (countSubMemo(s1, s2, ind1 - 1, ind2 - 1, dp)
                    + countSubMemo(s1, s2, ind1 - 1, ind2, dp));
        } else {
            return dp[ind1][ind2] = countSubMemo(s1, s2, ind1 - 1, ind2, dp);
        }
    }

    // time complexity: O(n x m)
    // time complexity: O(n x m)
    static int countSubTabu(String s1, String s2, int n, int m, int dp[][]) {
        
        for (int ind1 = 0; ind1 <= n; ind1++) {
            dp[ind1][0] = 1;
        }

        // NOTE: the m should start from 1 otherwise it will overrite the prev loop 0th col
        for (int ind2 = 1; ind2 <= m; ind2++) {
            dp[0][ind2] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            
            for (int ind2 = 1; ind2 <= m; ind2++) {
                
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = (dp[ind1 - 1][ind2 - 1] + dp[ind1 - 1][ind2]);
                    
                } else {
                    
                    dp[ind1][ind2] = dp[ind1 - 1][ind2];
                }
            }
        }
        return dp[n][m];
    }
    
    
    // time complexity: O(n x m)
    // space optimization: O(one row n + one row m)
    static int countSubSpOpt(String s1, String s2, int n, int m) {

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        
        prev[0] = curr[0] = 1;
        
        for (int ind1 = 1; ind1 <= n; ind1++) {

            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    curr[ind2] = (prev[ind2 - 1] + prev[ind2]);

                } else {
                    
                    curr[ind2] = prev[ind2];
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    static int countSub1Arr(String s1, String s2, int n, int m) {
        int[] prev = new int[m + 1];
        
        prev[0] = 1;
        
        for (int ind1 = 1; ind1 <= n; ind1++) {

            for (int ind2 = m; ind2 >= 1; ind2--) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    prev[ind2] = (prev[ind2 - 1] + prev[ind2]);

                } else {
                    
                    prev[ind2] = prev[ind2];
                }
            }
        }
        return prev[m];
    }

}
