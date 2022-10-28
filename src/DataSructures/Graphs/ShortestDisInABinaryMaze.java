package DataSructures.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int dist;
    int row;
    int col;

    public Pair(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

public class ShortestDisInABinaryMaze {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // if the starting row, col is 0 then we cannot move.
        if (grid[source[0]][source[1]] == 0) {
            return -1;
        }

        if (source[0] == destination[0] && source[1] == destination[1])
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        int[][] dis = new int[n][m];
        for (int[] is : dis) {
            Arrays.fill(is, (int) 1e9);
        }
        // since the change in the distance of the each cell is +1 so we donot need the
        // priority queue.
        Queue<Pair> q = new LinkedList<>();
        dis[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {

            int dist = q.peek().dist;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] != 0
                        && dist + 1 < dis[nrow][ncol]) {
                    dis[nrow][ncol] = dist + 1;
                    // TODO: didn't get this line, how can we return the dist + 1 as soon as we
                    // reach the destination, we might even find the smaller path from the other
                    // path. even the code works without this condn but it takes a bit more time
                    // since we are filling the entire dist array.
                    // if (nrow == destination[0] && ncol == destination[1]) return dist + 1;
                    q.add(new Pair(dist + 1, nrow, ncol));
                }
            }
        }
        return -1;
    }
}
