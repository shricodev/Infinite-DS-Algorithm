package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleDirectedDFS {

    // time complexity; O(v + e)
    // space complexity; O(2n)
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        // these two lines not needed.
        Arrays.fill(vis, false);
        Arrays.fill(pathVis, false);

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(vis, pathVis, adj, i) == true) return true;
            }
        }
        return false;
    }

    private boolean dfs(boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj, int node) {

        vis[node] = true;
        pathVis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(vis, pathVis, adj, it) == true) return true;
            } else if (vis[it] == true && pathVis[it] == true) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
