package DynamicProgramming.String;

import java.util.Arrays;

public class LongPalindSubseq {
    public static void main(String[] args) {
        String s1 = "abcba";
        String s2 = "";

        // taking the reverse of s1 in s2.
        for (int i = s1.length() - 1; i >= 0; i--) {
            s2 = s2 + s1.charAt(i);
        }

        int ind1 = s1.length() - 1;
        int[][] dp = new int[ind1 + 2][ind1 + 2];

        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(lcsTabu(s1, s2, dp));
        // System.out.println(lcsRec(ind1, ind1, s1, s2));
    }

    
    // this is the same tabulation code of the LondComSubseLen just the approacch here is
    // find the longest common subse in the s1 and reverse of s1, then we will get the longest palindromic 
    // subsequences.
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
}
