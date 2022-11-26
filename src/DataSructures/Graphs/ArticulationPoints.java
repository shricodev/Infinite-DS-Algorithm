package DataSructures.Graphs;

import java.util.ArrayList;

public class ArticulationPoints {
    private int timer = 0;

    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] mark = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        int[] vis = new int[n];
        ArrayList<Integer> points = new ArrayList<>();

        // since the graph can have multiple components so
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(time, low, vis, i, -1, adj, mark);
            }
        }

        // we are creating a hash of the mark since we don't want to have same
        // articulation point multiple times.
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                points.add(i);
            }
        }

        if (points.size() == 0) {
            points.add(-1);
        }

        return points;
    }

    private void dfs(int[] time, int[] low, int[] vis, int node, int parent, ArrayList<ArrayList<Integer>> adj,
            int[] mark) {

        vis[node] = 1;
        time[node] = low[node] = timer++;
        int child = 0;
        for (int it : adj.get(node)) {
            if (parent == it)
                continue;
            if (vis[it] == 0) {
                dfs(time, low, vis, it, node, adj, mark);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= time[node] && parent != -1) {
                    mark[node] = 1;
                    ;
                }
                child++;
            } else {
                // if the node is vis then we take the min of the low[node] and time[it] not
                // low[it].
                low[node] = Math.min(low[node], time[it]);
            }
        }
        if (parent == -1 && child > 1) {
            mark[node] = 1;
        }
    }
}
