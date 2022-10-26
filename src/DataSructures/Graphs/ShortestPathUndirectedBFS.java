package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ShortestPathUndirectedBFS {
    
    // time complexity; o(v + 2e)
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // making the adjacency list.
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    q.add(it);
                    dist[it] = dist[node] + 1;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;

    }
}
