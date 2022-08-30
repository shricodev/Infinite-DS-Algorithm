package DynamicProgramming.String;

import java.util.Arrays;

public class MinmInsertDelStrAtoStrB {
    public static void main(String[] args) {
        String s1 = "abcdfgdfba";
        String s2 = "abcde";

        int ind1 = s1.length() - 1;
        int ind2 = s2.length() - 1;
        int[][] dp = new int[ind1 + 2][ind2 + 2];

        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(lcsTabu(s1, s2, dp));
    }

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
        // return dp[s1.length()][s2.length()];
        // the only change from the palindromeSubsequence is this line.
        int deletions = s1.length() - dp[s1.length()][s2.length()];
        int insertions = s2.length() - dp[s1.length()][s2.length()];
        return deletions + insertions;
    }
}
