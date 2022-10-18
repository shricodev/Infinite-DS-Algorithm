package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleUndirectedDFS {

    static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[v];
        // this is indeed not required but i am doing to make things simpler.
        Arrays.fill(vis, false);

        // running a loop to handle the connected components cases
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                // for all the first node we set the parent to -1. cuz we have connected components
                if (dfs(v, adj, i, vis, -1))
                    return true;
            }
        }
        return false;
    }

    // time complexity: O(n + 2E)
    // space complexity: O(n) -> stack + O(n) -> visited array.
    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, int parent) {

        vis[node] = true;

        for (Integer adjNode : adj.get(node)) {

            if (!vis[adjNode]) {
                // if we ever encounter a true then return true, there is no need to check for
                // the further graph.
                if (dfs(v, adj, adjNode, vis, node) == true)
                    return true;

                // this is for the case when it encounters a visited element
            } else if (parent != adjNode) {
                return true;
            }
        }

        return false;
    }
}
