package DynamicProgramming.Grids;

import java.util.Arrays;

public class ChocolatePick {

    public static void main(String[] args) {
        int arr[][] = {
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 },
        };
        int n = arr.length;
        int m = arr[0].length;
        int row = 0;
        int col1 = 0;
        int col2 = m - 1;
        System.out.println(chocolatePickRec(n, m, row, col1, col2, arr));

        // for memoization
        // since there are three paramater changing making a 3D dp.
        int[][][] dp = new int[n][m][m];

        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        System.out.println(chocolatePickMemo(n, m, row, col1, col2, arr, dp));

        // for tabulation.
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, 0);
            }
        }

        System.out.println(chocolatePickTabu(n, m, arr, dp));


        System.out.println(chocolatePickNoSp(n, m, arr));

    }

    // problem link: HARD
    // https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885
    // time complexity: O(3^n * 3^n)
    // space complexity: O(N) -> stack space
    // since the bob and alice both move to the another row consecutively so taking
    // a single row.
    static int chocolatePickRec(int n, int m, int row, int col1, int col2, int[][] arr) {

        // making sure that i place the out of bound base case condn first.
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return (int) -1e8;
        }

        // destination base case.
        if (row == n - 1) {
            if (col1 == col2) {
                return arr[row][col1]; // or col2 doesnt matter.
            } else {
                return arr[row][col1] + arr[row][col2];
            }
        }

        int maxm = 0;
        // since for every alice move we have three move for bob {-1, 0, 1} i.e 3 x 3
        // moves.
        for (int j1 = -1; j1 <= 1; j1++) {

            for (int j2 = -1; j2 <= 1; j2++) {

                if (col1 == col2) {
                    int ans = arr[row][col1] + chocolatePickRec(n, m, row + 1, col1 + j1, col2 + j2, arr);
                    maxm = Math.max(ans, maxm);

                } else {
                    int ans = arr[row][col1] + arr[row][col2]
                            + chocolatePickRec(n, m, row + 1, col1 + j1, col2 + j2, arr);
                    maxm = Math.max(ans, maxm);
                }
            }
        }
        return maxm;
    }

    // time complexity: O(nxmxm) * 9
    // space complexity: O(nxmxm) + O(N) -> stack space
    static int chocolatePickMemo(int n, int m, int row, int col1, int col2, int[][] arr, int[][][] dp) {

        // making sure that i place the out of bound base case condn first.
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return (int) -1e8;
        }

        // destination base case.
        if (row == n - 1) {
            if (col1 == col2) {
                return arr[row][col1]; // or col2 doesnt matter.
            } else {
                return arr[row][col1] + arr[row][col2];
            }
        }

        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        int maxm = 0;
        // since for every alice move we have three move for bob {-1, 0, 1} i.e 3 x 3
        // moves.
        for (int j1 = -1; j1 <= 1; j1++) {

            for (int j2 = -1; j2 <= 1; j2++) {

                if (col1 == col2) {
                    int ans = arr[row][col1] + chocolatePickMemo(n, m, row + 1, col1 + j1, col2 + j2, arr, dp);
                    maxm = Math.max(ans, maxm);

                } else {
                    int ans = arr[row][col1] + arr[row][col2]
                            + chocolatePickMemo(n, m, row + 1, col1 + j1, col2 + j2, arr, dp);
                    maxm = Math.max(ans, maxm);
                }
            }
        }
        return dp[row][col1][col2] = maxm;
    }

    // this is a complete copy of the code of striver.
    // not quiet confident in the tabulation code.
    // NOTE: for 3D dp there is no need to even go till the tabulation, memoization is enough
    static int chocolatePickTabu(int n, int m, int[][] arr, int[][][] dp) {
        
        // base case
        for (int j1 = 0; j1 < m; j1++) {

            for (int j2 = 0; j2 < m; j2++) {

                if (j1 == j2) {
                    dp[n - 1][j1][j2] = arr[n - 1][j1];

                } else {
                    dp[n - 1][j1][j2] = arr[n - 1][j1] + arr[n - 1][j2];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {

            for (int j1 = 0; j1 < m; j1++) {

                for (int j2 = 0; j2 < m; j2++) {

                    // since for every alice move we have three move for bob {-1, 0, 1} i.e 3 x 3
                    // moves.
                    
                    int maxm = 0;
                    
                    for (int col1 = -1; col1 <= 1; col1++) {
                        
                        for (int col2 = -1; col2 <= 1; col2++) {
                            
                            int ans = 0;
                            if (j1 == j2)
                            ans = arr[row][j1];
                            else
                            ans = arr[row][j1] + arr[row][j2];
                            
                            if (j1 + col1 >= 0 && j1 + col1 < m && j2 + col2 >= 0 && j2 + col2 < m)
                            ans += dp[row + 1][j1 + col1][j2 + col2];
                            else
                            ans += (int) -1e8;
                            
                            maxm = Math.max(ans, maxm);
                        }
                    }
                    dp[row][j1][j2] = maxm;
                }
            }
        }
        return dp[0][0][m - 1];
    }
    
    // this is a complete copy of the code of striver.
    // not quiet confident in the code.
    // this is no way needed, no need to even understand in the future.
    static int chocolatePickNoSp(int n, int m, int[][] arr) {
        int[][] front = new int[m][m];
        int[][] current = new int[m][m];

        // base case
        for (int j1 = 0; j1 < m; j1++) {

            for (int j2 = 0; j2 < m; j2++) {

                if (j1 == j2) {
                    front[j1][j2] = arr[n - 1][j1];

                } else {
                    front[j1][j2] = arr[n - 1][j1] + arr[n - 1][j2];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    // since for every alice move we have three move for bob {-1, 0, 1} i.e 3 x 3
                    // moves.

                    int maxm = (int) -1e8;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;
                            if (j1 == j2)
                                ans = arr[row][j1];
                            else
                                ans = arr[row][j1] + arr[row][j2];

                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) -1e8;
                            else
                                ans += front[j1 + di][j2 + dj];

                            maxm = Math.max(ans, maxm);
                        }
                    }
                    current[j1][j2] = maxm;
                }
            }
            for (int a = 0; a < m; a++) {
                front[a] = (int[])(current[a].clone());
            }
        }
        return front[0][m - 1];
    }
}