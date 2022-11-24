package DataSructures.Graphs;
import java.util.ArrayList;
import java.util.List;

// this is a tarjans algorithm question
public class BridgesInGraphTarjan {
    private int timer = 1;

    // in case of confusion in the future: https://www.youtube.com/watch?v=qrAub5z8FeA
    // tc; O(v + 2e)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        int[] vis = new int[n];
        int[] time = new int[n];
        int[] lowTime = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> conn : connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(vis, time, lowTime, adj, 0, -1, bridges);
        return bridges;
    }

    private void dfs(int[] vis, int[] time, int[] lowTime, List<List<Integer>> adj, int node, int parent, List<List<Integer>> bridges) {

        vis[node] = 1;
        time[node] = lowTime[node] = timer++;
        for (Integer it : adj.get(node)) {
            // if it is a parent, then we don't consider it.
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(vis, time , lowTime, adj, it, node, bridges);
                lowTime[node] = Math.min(lowTime[node], lowTime[it]);

                // if it is violated then it is a bridge.
                if (lowTime[it] > time[node]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(it);
                    bridges.add(bridge);
                }
            }
            else {
                // if it is visited then we take the min of the node.
                lowTime[node] = Math.min(lowTime[node], lowTime[it]);
            }
        }
    }
}
