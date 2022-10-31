package ImpAlgorithms.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }

}

public class DijkstraUsingPriorityQueue {

    // time complexity; O(elogv)
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // we will be adding the elements in the priority queue in (dist, node) format.
        // this is the minm heap priority queue.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dist = new int[v];
        Arrays.fill(dist, (int) 1e9);
        // distance from the source to the source is equals 0
        pq.add(new Pair(0, S));

        while (pq.size() != 0) {
            // distance till the node.
            int distance = pq.peek().distance;
            int node = pq.peek().node;

            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWt = adj.get(node).get(i).get(1);

                if (distance + edgeWt < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
