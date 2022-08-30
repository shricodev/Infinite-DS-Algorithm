package DynamicProgramming.String;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "whgtdwhgtdg";
        String s2 = "aswcfg";
        int n = s1.length();
        int m = s2.length();
        System.out.println(distanceRec(s1, s2, n - 1, m - 1));

        // for memoization
        int[][] dp = new int[n + 1][m + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        System.out.println(distanceMemo(s1, s2, n - 1, m - 1, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(distanceTabu(s1, s2, n, m, dp));

        // for space optimization
        System.out.println(distanceSpOpt(s1, s2, n, m));

    }

    // time complexity: O(exponential) -> 3^n * 3^m
    // space complexity: O(n + m)
    static int distanceRec(String s1, String s2, int ind1, int ind2) {

        // if the index 1 is -ve then we need to insert the ind2 + 1
        // element to make the string2.
        if (ind1 < 0)
            return ind2 + 1;

        if (ind2 < 0)
            return ind1 + 1;

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 0 + distanceRec(s1, s2, ind1 - 1, ind2 - 1);
        }

        // since it didnt match then we will insert the element but the ind1 should
        // remain the same place.
        int insert = 1 + distanceRec(s1, s2, ind1, ind2 - 1);

        int delete = 1 + distanceRec(s1, s2, ind1 - 1, ind2);

        int replace = 1 + distanceRec(s1, s2, ind1 - 1, ind2 - 1);

        return Math.min(insert, Math.min(delete, replace));
    }

    // time complexity: O(n x m)
    // space complexity: O(n + m) + O(n x m)
    static int distanceMemo(String s1, String s2, int ind1, int ind2, int[][] dp) {

        if (ind1 < 0)
            return ind2 + 1;

        if (ind2 < 0)
            return ind1 + 1;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 0 + distanceMemo(s1, s2, ind1 - 1, ind2 - 1, dp);
        }

        // since it didnt match then we will insert the element but the ind1 should
        // remain the same place.
        int insert = 1 + distanceMemo(s1, s2, ind1, ind2 - 1, dp);

        int delete = 1 + distanceMemo(s1, s2, ind1 - 1, ind2, dp);

        int replace = 1 + distanceMemo(s1, s2, ind1 - 1, ind2 - 1, dp);

        return dp[ind1][ind2] = Math.min(insert, Math.min(delete, replace));
    }

    static int distanceTabu(String s1, String s2, int n, int m, int[][] dp) {

        for (int ind1 = 0; ind1 <= n; ind1++) {
            // since this is a 1 index based so no need to do + 1
            dp[ind1][0] = ind1;
        }

        // NOTE: the m should start from 1 otherwise it will overrite the prev loop 0th
        // col
        for (int ind2 = 1; ind2 <= m; ind2++) {
            dp[0][ind2] = ind2;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {

            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 0 + dp[ind1 - 1][ind2 - 1];

                } else {

                    // since it didnt match then we will insert the element but the ind1 should
                    // remain the same place.
                    int insert = 1 + dp[ind1][ind2 - 1];

                    int delete = 1 + dp[ind1 - 1][ind2];

                    int replace = 1 + dp[ind1 - 1][ind2 - 1];

                    dp[ind1][ind2] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }

    static int distanceSpOpt(String s1, String s2, int n, int m) {
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // since this is a 1 index based so no need to do + 1
        // NOTE: the m should start from 1 otherwise it will overrite the prev loop 0th
        // col
        for (int ind2 = 0; ind2 <= m; ind2++) {
            prev[ind2] = ind2;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {

            curr[0] = ind1;

            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    curr[ind2] = 0 + prev[ind2 - 1];

                } else {

                    // since it didnt match then we will insert the element but the ind1 should
                    // remain the same place.
                    int insert = 1 + curr[ind2 - 1];

                    int delete = 1 + prev[ind2];

                    int replace = 1 + prev[ind2 - 1];

                    curr[ind2] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = (int[])(curr.clone());
        }
        return prev[m];
    }

}
