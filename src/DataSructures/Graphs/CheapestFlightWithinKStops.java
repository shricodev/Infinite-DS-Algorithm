package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Pair {

    int adjNode;
    int cost;
    public Pair (int adjNode, int cost) {
        this.adjNode = adjNode;
        this.cost = cost;
    }
}

class Tuple {
    int stops;
    int node;
    int cost;

    public Tuple (int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

public class CheapestFlightWithinKStops {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        // n is the no of nodes, and m is the edges. It should not be the flights[0].length
        int m = flights.length;

        // creating the adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // this is the directed graph somaking the adj lsit from one only.
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // we use queue here than the priority queue, since the stops is increasing by +1.
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        while (!q.isEmpty()) {
            int stops = q.peek().stops;
            int node = q.peek().node;
            int cost = q.peek().cost;
            q.remove();
            // if stops is already > k then there is no need to iterate over its neigbours
            if (stops >  k) continue;

            for (Pair it : adj.get(node)) {
                int adjNode = it.adjNode;
                int adjPrice = it.cost;
                if (cost + adjPrice < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + adjPrice;
                    q.add(new Tuple(stops + 1,  adjNode, cost + adjPrice));
                }
            }
        }
        if (dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}
