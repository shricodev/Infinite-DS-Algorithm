package DynamicProgramming.String;

import java.util.Arrays;

public class LongComSubstrLen {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abzd";
        int ind1 = s1.length() - 1;
        int ind2 = s2.length() - 1;

        // recursion
        System.out.println(lcsRec(ind1, ind2, s1, s2, 0));

        // tabulation
        int[][] dp = new int[ind1 + 2][ind2 + 2];
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(lcsTabu(s1, s2, dp));
    }

    static int lcsRec(int ind1, int ind2, String s1, String s2, int count) {
        if (ind1 < 0 || ind2 < 0)
            return count;

        if (s1.charAt(ind1) == s2.charAt(ind2))
            count = lcsRec(ind1 - 1, ind2 - 1, s1, s2, count + 1);

        count = Math.max(count, Math.max(lcsRec(ind1 - 1, ind2, s1, s2, 0), lcsRec(ind1, ind2 - 1, s1, s2, 0)));
        return count;
    }

    // since the index is the only changing value so taking the index also in the
    // parameter.
    static int lcsTabu(String s1, String s2, int dp[][]) {

        // since the base case is of ind < 0 i.e, -1 so shifting the index, i.e take
        // ind1 as ind1 - 1 and ind2 as ind2 - 1.
        // here the index == 0 represents the index = -1.
        int ans = 0;
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
                    ans = Math.max(ans, take);

                } else {

                    // this is the only change we need to make to the subsequence tabulation version
                    // of code to make it work here.
                    notTake = 0;
                }

                dp[ind1][ind2] = Math.max(take, notTake);
            }
        }
        return ans;
    }
}
