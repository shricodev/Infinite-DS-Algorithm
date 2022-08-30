package DynamicProgramming.String;

import java.util.Arrays;

public class ShortComSuperseqPrint {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        int ind1 = s1.length() - 1;
        int ind2 = s2.length() - 1;
        int[][] dp = new int[ind1 + 2][ind2 + 2];

        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        lcsTabu(s1, s2, dp);
    }

    static void lcsTabu(String s1, String s2, int dp[][]) {

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
        // return dp[s1.length()][s2.length()];

        // this is the code to return the length.
        // int lcs = dp[s1.length()][s2.length()];
        // int s1NoLcs = s1.length() - lcs;
        // int s2NoLcs = s2.length() - lcs;
        // return lcs + s1NoLcs + s2NoLcs;

        // for printing.
        int i = s1.length();
        int j = s2.length();
        StringBuilder ans = new StringBuilder("");

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        // for the last elements.
        while (i > 0) {
            ans.append(s1.charAt(i - 1));
            i = i - 1;
        }

        while (j > 0) {
            ans.append(s2.charAt(j - 1));
            j = j - 1;
        }
        
        System.out.println(ans.reverse());
    }
}
