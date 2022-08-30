package DynamicProgramming.String;

import java.util.Arrays;

public class WildcardMatch {
    public static void main(String[] args) {
        String s1 = "aa*";
        String s2 = "aa";

        int n = s1.length();
        int m = s2.length();
        System.out.println(wildcardMatchRec(s1, s2, n - 1, m - 1));

        // for memoization
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(wildcardMatchMemo(s1, s2, n - 1, m - 1, dp));

        // for tabulation
        boolean[][] dp2 = new boolean[n + 1][m + 1];
        for (boolean[] a : dp2) {
            Arrays.fill(a, false);
        }
        System.out.println(wildcardMatchTabu(s1, s2, n, m, dp2));

        // space optimization
        System.out.println(wildcardMatchSpOpt(s1, s2, n, m));

    }

    // time complexity: O(exponential)
    // space complexity: O(n + m)
    static boolean wildcardMatchRec(String s1, String s2, int ind1, int ind2) {

        if (ind1 < 0 && ind2 < 0)
            return true;

        if (ind1 < 0 && ind2 >= 0)
            return false;

        if (ind2 < 0 && ind1 >= 0) {
            for (int i = 0; i <= ind1; i++) {
                if (s1.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if (s1.charAt(ind1) == s2.charAt(ind2) || s1.charAt(ind1) == '?') {
            return wildcardMatchRec(s1, s2, ind1 - 1, ind2 - 1);
        }

        boolean notTake = false;
        boolean take = false;

        // if the char is * then we need to consider two cases. take or notTake
        if (s1.charAt(ind1) == '*') {
            notTake = wildcardMatchRec(s1, s2, ind1 - 1, ind2);
            take = wildcardMatchRec(s1, s2, ind1, ind2 - 1);
            return take || notTake;
        }

        return false;

    }

    // time complexity; O(n x m)
    // space complexity: O(n + m) + O(n x m)
    static int wildcardMatchMemo(String s1, String s2, int ind1, int ind2, int[][] dp) {

        if (ind1 < 0 && ind2 < 0)
            return 1;

        if (ind1 < 0 && ind2 >= 0)
            return 0;

        if (ind2 < 0 && ind1 >= 0) {
            for (int i = 0; i <= ind1; i++) {
                if (s1.charAt(i) != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2) || s1.charAt(ind1) == '?') {
            return dp[ind1][ind2] = wildcardMatchMemo(s1, s2, ind1 - 1, ind2 - 1, dp);
        }

        int notTake = 0;
        int take = 0;

        // if the char is * then we need to consider two cases. take or notTake
        if (s1.charAt(ind1) == '*') {
            notTake = wildcardMatchMemo(s1, s2, ind1 - 1, ind2, dp);
            take = wildcardMatchMemo(s1, s2, ind1, ind2 - 1, dp);
            return dp[ind1][ind2] = (take == 1 || notTake == 1) ? 1 : 0;
        }

        return dp[ind1][ind2] = 0;
    }

    static boolean isAllStars(String S1, int i) {

        // S1 is taken in 1-based indexing
        for (int j = 1; j <= i; j++) {
            if (S1.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    static boolean wildcardMatchTabu(String s1, String s2, int n, int m, boolean[][] dp2) {

        dp2[0][0] = true;

        for (int ind2 = 1; ind2 <= m; ind2++) {
            dp2[0][ind2] = false;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            dp2[ind1][0] = isAllStars(s1, ind1);
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {

            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1) || s1.charAt(ind1 - 1) == '?') {
                    dp2[ind1][ind2] = dp2[ind1 - 1][ind2 - 1];

                } else {

                    // if the char is * then we need to consider two cases. take or notTake
                    if (s1.charAt(ind1 - 1) == '*') {
                        dp2[ind1][ind2] = dp2[ind1 - 1][ind2] || dp2[ind1][ind2 - 1];

                    } else {
                        dp2[ind1][ind2] = false;
                    }
                }
            }
        }
        return dp2[n][m];
    }

    static boolean wildcardMatchSpOpt(String s1, String s2, int n, int m) {
        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        prev[0] = true;

        for (int ind1 = 1; ind1 <= n; ind1++) {

            curr[0] = isAllStars(s1, ind1);

            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1) || s1.charAt(ind1 - 1) == '?') {
                    curr[ind2] = prev[ind2 - 1];
                } else if (s1.charAt(ind1 - 1) == '*') {
                    curr[ind2] = prev[ind2] || curr[ind2 - 1];
                } else {
                    curr[ind2] = false;
                }
            }
            prev = (boolean[])(curr.clone());
        }
        return prev[m];
    }

}
