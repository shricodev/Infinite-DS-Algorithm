package DynamicProgramming.String;

import java.util.Arrays;

public class LongComSubseLen {
    public static void main(String[] args) {
        String s1 = "abcba";
        String s2 = "abcbcba";
        int ind1 = s1.length() - 1;
        int ind2 = s2.length() - 1;
        System.out.println(lcsRec(ind1, ind2, s1, s2));

        // for memoization
        // dp of size [ind1 + 1][ind2 + 1] would work fine for the memoization but for
        // tabulation it needs 1 more since we are using the index in the shifted form.
        int[][] dp = new int[ind1 + 2][ind2 + 2];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        System.out.println(lcsMemo(ind1, ind2, s1, s2, dp));

        // for tabulation
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(lcsTabu(s1, s2, dp));

        // for space optimization
        System.out.println(lcsSpOpt(s1, s2));
    }

    // time complexity: o(2^n(first string subsequence) * 2^m(second string
    // subsequence))
    // space complexity: O(exponential)
    // link:
    // https://www.codingninjas.com/codestudio/problems/longest-common-subsequence_624879
    static int lcsRec(int ind1, int ind2, String s1, String s2) {

        // the base case here should not be id1 == 0 || ind2 == 0 because if ind1 is 0
        // then the ind2 can be more.
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        int take = 0;
        int notTake = 0;

        if (s1.charAt(ind1) == s2.charAt(ind2)) {

            take = 1 + lcsRec(ind1 - 1, ind2 - 1, s1, s2);
        }

        notTake = 0 + Math.max(lcsRec(ind1, ind2 - 1, s1, s2), lcsRec(ind1 - 1, ind2, s1, s2));

        return Math.max(take, notTake);
    }

    // time complexity: O(n x m)
    // space complexity; O(n x m) -> dp + O(n + m) -> stack space
    static int lcsMemo(int ind1, int ind2, String s1, String s2, int dp[][]) {

        // the base case here should not be id1 == 0 || ind2 == 0 because if ind1 is 0
        // then the ind2 can be more.
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        int take = 0;
        int notTake = 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {

            take = 1 + lcsMemo(ind1 - 1, ind2 - 1, s1, s2, dp);
        }

        notTake = 0 + Math.max(lcsMemo(ind1, ind2 - 1, s1, s2, dp), lcsMemo(ind1 - 1, ind2, s1, s2, dp));

        return dp[ind1][ind2] = Math.max(take, notTake);
    }

    // since the index is the only changing value so taking the index also in the
    // parameter.
    static int lcsTabu(String s1, String s2, int dp[][]) {

        // since the base case is of ind < 0 i.e, -1 so shifting the index, i.e take
        // ind1 as ind1 - 1 and ind2 as ind2 - 1.
        // here the index == 0 represents the index = -1.

        for (int ind2 = 0; ind2 <= s2.length(); ind2++) {
            dp[0][ind2] = 0;
        }

        for (int ind1 = 0; ind1 <= s1.length(); ind1++) {
            dp[ind1][0] = 0;
        }

        for (int ind1 = 1; ind1 <= s1.length(); ind1++) {

            for (int ind2 = 1; ind2 <= s2.length(); ind2++) {

                int take = 0;
                int notTake = 0;

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {

                    take = 1 + dp[ind1 - 1][ind2 - 1];

                } else {

                    notTake = 0 + Math.max(dp[ind1][ind2 - 1], dp[ind1 - 1][ind2]);
                }

                dp[ind1][ind2] = Math.max(take, notTake);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    static int lcsSpOpt(String s1, String s2) {

        // even if the s2 length is shorter than the s1 length the longest common
        // subsequence is going to be at max the length of the s2.
        int[] prev = new int[s2.length() + 1];

        for (int ind2 = 0; ind2 <= s2.length(); ind2++) {
            prev[ind2] = 0;
        }

        prev[0] = 0;

        for (int ind1 = 1; ind1 <= s1.length(); ind1++) {

            int[] curr = new int[s2.length() + 1];

            for (int ind2 = 1; ind2 <= s2.length(); ind2++) {

                int take = 0;
                int notTake = 0;

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {

                    take = 1 + prev[ind2 - 1];

                } else {

                    notTake = 0 + Math.max(curr[ind2 - 1], prev[ind2]);
                }

                curr[ind2] = Math.max(take, notTake);
            }
            prev = (int[]) (curr.clone());
        }
        return prev[s2.length()];
    }
}
