package LeetcodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> adj = new ArrayList<>();

        // creating the adjacency list.
        for (int[] ls : dislikes) {
            int u = ls[0];
            int v = ls[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // since the nodes are from 1.
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        // the graph might have multiple components.
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // this fx is called the times as there are no of components.
                if (bfs(i, color, adj) == false)
                    return false;
            }
        }
        return true;
    }

    private boolean bfs(int node, int[] color, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (color[u] == color[v])
                    return false;

                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.add(v);
                }
            }
        }
        return true;
    }
}
