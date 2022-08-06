package BackTracking;

import java.util.ArrayList;

public class RatInAMazeNoMultipleIf {
    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
                     {1, 1, 0, 1}, 
                     {1, 1, 1, 0},
                     {0, 1, 1, 1}};

        System.out.println(findPath(m, n));
    }

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

        // these are the indices for down, left, right, up for x and y axis.
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};


        if (m[0][0] != 0) solve(m, vis, n, s, ans, x, y, dx, dy);
        
        return ans;
    }

    private static void solve(int[][] m, int[][] vis, int n, String s, ArrayList<String> ans, int x, int y, int[] dx, int[] dy) {

        if (x == n - 1 && y == n - 1) {
            ans.add(s);
            return;
        }

        String dir = "DLRU";

        // since we have four available directions
        // with this approach the code looks a bit cleaner. 
        for (int ind = 0; ind < 4; ind++) {
            int nextx = x + dx[ind];
            int nexty = y + dy[ind];

            // all the condition checks here done.
            if (nextx >= 0 && nexty >= 0 && nextx < n && nexty < n && vis[nextx][nexty] != 1 && m[nextx][nexty] == 1) {
                vis[x][y] = 1;
                solve(m, vis, n, s + dir.charAt(ind), ans, nextx, nexty, dx, dy);
                vis[x][y] = 0;
            }
        }

    }

    
}
