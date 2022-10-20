package DataSructures.Graphs;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStatesCycleDetection {

    // time complexity: O(V + 2e)
    // space complexity: O(4V)
    public List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        boolean[] isSafe = new boolean[v];
        List<Integer> safeNodes = new ArrayList<>();
        // these two lines not needed.
        Arrays.fill(vis, false);
        Arrays.fill(pathVis, false);

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(vis, pathVis, adj, i, isSafe);
            }
        }

        for (int i = 0; i < v; i++) {
            if (isSafe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(boolean[] vis, boolean[] pathVis, List<List<Integer>> adj, int node, boolean[] isSafe) {

        vis[node] = true;
        pathVis[node] = true;
        isSafe[node] = false;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(vis, pathVis, adj, it, isSafe) == true) {
                    isSafe[node] = false;
                    return true;
                }
            } else if (vis[it] == true && pathVis[it] == true) {
                isSafe[node] = false;
                return true;
            }
        }
        // if we get to a point when there is no outgoing edge, then it means it's safe.
        // dfs is done for the node, and it is not connected to any cyclic nodes.
        isSafe[node] = true;
        pathVis[node] = false;
        return false;
    }


}
