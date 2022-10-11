package DynamicProgramming.Partition;

import java.util.Arrays;

public class BooleanExpToTrue {
    public static void main(String[] args) {
        String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        int n = s.length();
        int[][][] dp = new int[n+1][n+1][2];
        for (int[][] ls2 : dp) {
            for (int[] ls : ls2) {
                Arrays.fill(ls, -1);
            }
        }
        System.out.println(findWaysMemo(s, 0, n - 1, true, dp));
    }

    // here i and j represent start and end index
    // we are checking for the false consition also because the OR and Xor operator
    // also relies on the false to return true.
    static int findWaysMemo(String s, int i, int j, boolean isTrue, int[][][] dp) {

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == true) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        if (dp[i][j][isTrue == true ? 1 : 0] != -1) {
            return dp[i][j][isTrue == true ? 1 : 0];
        }

        int ways = 0;

        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lT = findWaysMemo(s, i, k - 1, true, dp);
            int lF = findWaysMemo(s, i, k - 1, false, dp);
            int rT = findWaysMemo(s, k + 1, j, true, dp);
            int rF = findWaysMemo(s, k + 1, j, false, dp);

            if (s.charAt(k) == '&') {
                if (isTrue == true) {
                    ways += lT * rT;
                } else {
                    ways += (lF * rF) + (lF * rT) + (lT * rF);
                }

            } else if (s.charAt(k) == '|') {
                if (isTrue == true) {
                    ways += (lT * rT) + (lF * rT) + (lT * rF);
                } else {
                    ways += (lF * rF);
                }

                // this means the xor operator.
            } else {
                if (isTrue == true) {
                    ways += (lT * rF) + (lF * rT);
                } else {
                    ways += (rF * lF) + (lT * rT);
                }
            }
        }
        return dp[i][j][isTrue == true ? 1 : 0] = ways % 1003;
    }
}
