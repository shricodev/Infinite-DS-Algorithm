package DynamicProgramming.Grids;

import java.util.Arrays;

public class MazeWithObstacles {
    public static void main(String[] args) {
        int[][] arr = {
            {0, 0, 0, 0},
            {0, -1, 0, 0},
            {0, 0, 0, 0}
        };
        int row = arr.length - 1;
        // this works just fine for the same col for every row.
        int col = arr[0].length - 1;

        int[][] dp = new int[row + 1][col + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(solveRec(row, col, arr));
        System.out.println(solveMemo(row, col, arr, dp));
        System.out.println(solveTabu(row + 1, col + 1, arr, dp));

        // for no space
        System.out.println(solveNoSp(row + 1, col + 1, arr));
    }

    static int solveRec(int row, int col, int[][] arr) {

        if (row >= 0 && col >= 0 && arr[row][col] == -1) return 0;
        
        if (row == 0 && col == 0) return 1;
        
        if (row < 0 || col < 0) return 0;

        int up = solveRec(row - 1, col, arr);
        int left = solveRec(row, col - 1, arr);
        
        return up + left;
    }

    static int solveMemo(int row, int col, int[][] arr, int[][] dp) {

        if (row >= 0 && col >= 0 && arr[row][col] == -1) return 0;
        
        if (row == 0 && col == 0) return 1;
        
        if (row < 0 || col < 0) return 0;

        if (dp[row][col] != -1) return dp[row][col];

        int up = solveMemo(row - 1, col, arr, dp);
        int left = solveMemo(row, col - 1, arr, dp);
        
        return dp[row][col] = up + left;
    }

    static int solveTabu(int n, int m, int[][] arr, int[][] dp) {

        for (int row = 0; row < n; row++) {
            
            for (int col = 0; col < m; col++) {
                
                if (arr[row][col] == -1) {
                    dp[row][col] = 0;

                } else if (row == 0 && col == 0) {
                    dp[row][col] = 1;

                } else {

                    int left = 0;
                    int up = 0;
    
                    if(col > 0) left = dp[row][col - 1];
    
                    if(row > 0) up = dp[row - 1][col];
    
                    dp[row][col] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    static int solveNoSp(int n, int m, int[][] arr) {

        int[] prev = new int[m];

        for (int row = 0; row < n; row++) {

            int[] current = new int[m];

            for (int col = 0; col < m; col++) {

                if (arr[row][col] == -1) {
                    current[col] = 0;

                } else if (row == 0 && col == 0) {
                    current[col] = 1;

                } else {

                    int left = 0;
                    int up = 0;

                    if (col > 0) left = current[col - 1];

                    if(row > 0) up = prev[col];

                    current[col] = up + left;
                }
            }

            prev = current;
        }
        return prev[m - 1];
    }
}
