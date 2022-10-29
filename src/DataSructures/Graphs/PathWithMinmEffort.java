package DataSructures.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int diff;
    int row;
    int col;

    public Pair(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}

public class PathWithMinmEffort {

    // time complexity; O(elogv)
    int MinimumEffort(int heights[][]) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.diff - y.diff);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];
        for (int[] is : dis) {
            Arrays.fill(is, (int) 1e9);
        }
        pq.add(new Pair(0, 0, 0));
        dis[0][0] = 0;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, +1, 0, -1 };

        while (pq.size() != 0) {
            int diff = pq.peek().diff;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();
            // since it is the min heap of the diff, so when we reach the last row col then it means we are there with the min diff.
            if (row == n - 1 && col == m - 1) return diff;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newEffort = Math.max(diff, heights[nrow][ncol] - heights[row][col]);
                    if (newEffort < dis[nrow][ncol]) {
                        dis[nrow][ncol] = newEffort;
                        pq.add(new Pair(newEffort, nrow, ncol));
                    }
                }
            }
        }
        // if the distance is unreachable.
        return 0;
    }

}
