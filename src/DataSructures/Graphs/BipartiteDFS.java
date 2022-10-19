package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS {

    // time complexity; O(v + 2E)
    // space complexity: O(v)
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {

        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (dfs(v, adj, color, i, 0) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, int[] color, int node, int prevCol) {
        color[node] = prevCol;

        for (Integer adjNode : adj.get(node)) {
            if (color[adjNode] == -1) {

                if (dfs(v, adj, color, adjNode, 1 - prevCol) == false)
                    return false;

            } else if (prevCol == color[adjNode]) {
                    return false;
            }
        }
        return true;
    }

}
