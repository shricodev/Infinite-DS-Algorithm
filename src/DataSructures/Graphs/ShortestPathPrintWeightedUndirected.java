package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int first;
    int second;

    // the first is the distance, and the second is the node.
    public Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}

// ? this is a great qn. this concept can be helpful in the other qn as well which requires something like printing the path.
// * this qn uses a very good concept of memoizing where we came from using the parent array.
public class ShortestPathPrintWeightedUndirected {
    
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        // since this is the one based indexing, so adding one extra arraylist to the list.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

        int[] dis = new int[n + 1];
        int[] parent = new int[n + 1];

        // filling the parent[i] with the index value in the initial stage.
        for (int i = 1; i <= n; i++) {
            dis[i] = (int) 1e9;
            parent[i] = i;
        }

        // since the src node is always explicitely given as 1, so taking the src distance 0.
        dis[1] = 0;
        pq.add(new Pair(0, 1));
        while (pq.size() != 0) {
            int node = pq.peek().second;
            int distance = pq.peek().first;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edgeWt = it.second;
                if (distance + edgeWt < dis[adjNode]) {
                    dis[adjNode] = distance + edgeWt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        
        if (dis[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }
        int node = n;
        // for finding the src node.
        while (parent[node] != node) { // or dis[1] != 0
            path.add(node);
            node = parent[node];
        }
        path.add(1); // since the loop wont go for the src node.
        // since we are adding the path in the reverse fashion, so we need to return the reverse of the path.
        Collections.reverse(path);
        return path;

    }
}
