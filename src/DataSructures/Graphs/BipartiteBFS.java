package DataSructures.Graphs;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        // this will act as a visited array.
        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (bfs(i, v, adj, color) == false)
                    return false;
            }
        }

        return true;

    }

    private boolean bfs(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        // coloring the first node with the value 0;
        color[start] = 0;

        while (!q.isEmpty()) {
            Integer node = q.peek();
            q.remove();

            for (Integer adjNode : adj.get(node)) {

                if (color[adjNode] == -1) {
                    q.add(adjNode);
                    color[adjNode] = 1 - color[node];
                } else if (color[adjNode] == color[node]) {
                    return false;
                }

            }
        }
        return true;
    }
}
