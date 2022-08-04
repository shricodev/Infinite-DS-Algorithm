package BackTracking;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
                     {1, 1, 0, 1}, 
                     {1, 1, 1, 0},
                     {0, 1, 1, 1}};

        System.out.println(findPath(m, n));
    }

    // Time Complexity: O(4^(m*n)) -> m is the ways possible to move.
    // Space Complexity:  O(m*n)
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        int x = 0;
        int y = 0;
        String s = "";

        if (m[0][0] != 0) {
            solve(m, vis, n, s, ans, x, y);
        }
        return ans;
    }
    
    static void solve(int[][] m,int vis[][], int n, String s, ArrayList<String> ans, int x, int y) {
        if (x == n - 1 && y == n - 1) {
            ans.add(s);
            return;
        }
        
        // since we want the ans to be in the lexicographical order so
        // trying the movement in the order of D->L->R->U so there is no need to sort the ans array.
        
        // downward
        if (x + 1 < n && vis[x+1][y] == 0 && m[x + 1][y] == 1) {
            // when moving to the next block marking the current block as visited.
            vis[x][y] = 1;
            solve(m, vis, n, s + "D", ans, x + 1, y);
            // backtrack
            vis[x][y] = 0;
        }
        
        // left
        if (y - 1 >= 0 && vis[x][y - 1] == 0 && m[x][y - 1] == 1) {
            vis[x][y] = 1;
            solve(m, vis, n, s + "L", ans, x, y - 1);
            vis[x][y] = 0;
        }
    
        // right 
        if (y + 1 < n && vis[x][y + 1] == 0 && m[x][y + 1] == 1) {
            vis[x][y] = 1;
            solve(m, vis, n, s + "R", ans, x, y + 1);
            vis[x][y] = 0;
        }
        
        // up 
        if (x - 1 >= 0 && vis[x - 1][y] == 0 && m[x - 1][y] == 1) {
            vis[x][y] = 1;
            solve(m, vis, n, s + "U", ans, x - 1, y);
            vis[x][y] = 0;
        }
    }
}
