package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

// this algorithm works for even the -ve weights, and can be used to detect negative cycle. which Dijkstra fails!
public class BellmanFordAlgorithm {
    
    // time complexity; O(v x e)
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[s] = 0;
        // if there is no negative cycle then till here the bellman ford is working.
        // just loop for the v - 1 times and shortest distance from the src to all the nodes are found.
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // for detecting the negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                int[] temp = {-1};
                return temp;
            }
        }
        return dist;

    }
}
