package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class DetectCycleUndirectedBFS {

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[v + 1];
        Arrays.fill(vis, false);
        // this handles the case for the connected components.
        // NOTE: we say a graph has a cycle if any of the components has a cycle.
        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                // if any of the components return false, then it does not mean that all other component return false.
                if (bfs(v, adj, i, vis) == true)
                    return true;
            }
        }
        return false;
    }

    // time complexity: O(n + 2E
    // space complexity: O(n) + O(n)
    private boolean bfs(int v, ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis) {

        Queue<Pair> q = new LinkedList<>();
        // we adding the parent of the first node -1.
        q.add(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {
            int nodeVal = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            for (Integer adjNode : adj.get(nodeVal)) {
                if (!vis[adjNode]) {
                    q.add(new Pair(adjNode, nodeVal));
                    vis[adjNode] = true;
                
                    // this handles for the true case, if the adjacent node is true and the adjnode is not parent
                    // then it means that the first bfs call has made the node true, so return true.
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
}
