package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

// if we had to even return the mst then parent should also be declared.
class Pair {
    int wt;
    int node;

    public Pair(int wt, int node) {
        this.wt = wt;
        this.node = node;
    }
}

// * Spanning Tree: tree with exactly n nodes and n - 1 edges, and all nodes
// * reachable. (Single component.)
// * MST: spanning tree with minm sum
// * TIME COMPLEXITY: O(ElogE)
// reference: https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
public class PrimsAlgorithmMST {

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        int[] vis = new int[V];
        int sum = 0;

        pq.add(new Pair(0, 0));

        while (pq.size() != 0) {
            int node = pq.peek().node;
            int wt = pq.peek().wt;
            pq.remove();
            // it means it is already a part of the MST
            if (vis[node] == 1)
                continue;
            vis[node] = 1;
            sum += wt;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int adjWt = adj.get(node).get(i).get(1);
                // we dont actually mark the adjNode when entering as visited.
                if (vis[adjNode] != 1) {
                    pq.add(new Pair(adjWt, adjNode));
                }
            }
        }
        return sum;
    }
}
