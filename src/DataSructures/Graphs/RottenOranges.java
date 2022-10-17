package DataSructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

// ! NOTE: this is a very important qn which used the concept of doing operation
// ! simultaneously using BFS.
public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 2},
            {0, 1, 2},
            {2, 1, 1}
        } ;
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        // Code here

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 2) {
                    q.add(new Pair(row, col));
                    vis[row][col] = 2;
                }

                if (grid[row][col] == 1) {
                    cntFresh++;
                } else {
                    vis[row][col] = 0;
                }
            }
        }

        // if there is no fresh oranges then the time required will be 0.
        if (cntFresh == 0)
            return 0;

        int time = 0;
        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        int cnt = 0;

        while (!q.isEmpty()) {

            // this keeps track of all the oranges that are ready to rot the neighbour oranges.
            int sizeQ = q.size();
            int temp = 0;

            // when the size becomes zero it means that all the oranges they have rotten nearby and now its time
            // for just rotten oranges to rot the nearby oranges.
            while (sizeQ != 0) {
                int row = q.peek().row;
                int col = q.peek().col;
                q.remove();

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
                            && grid[nrow][ncol] == 1) {
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = 2;
                        cnt++;
                        temp++;
                    }
                }
                // one rotten orange have finished rotting the nearby oranges.
                sizeQ--;
            }

            if (temp != 0) {
                time++;
            }
        }

        if (cntFresh != cnt) {
            return -1;
        }
        return time;

    }
}
