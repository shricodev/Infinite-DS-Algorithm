package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    // time complexity; O(3(V+E))
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // step: 1: sort all the node in terms of the finishing time.
        // the stack top element is the starting point.
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, st, vis, adj);
            }
        }

        // step: 2: reverse the edge
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            vis[i] = 0;
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
            }
        }

        // step: 3 compute the dfs on the reverse adj list
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs2(node, vis, adjRev);
            }
        }
        return scc;
    }

    private void dfs(int node, Stack<Integer> st, int[] vis, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;

        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, st, vis, adj);
            }
        }
        st.push(node);
    }

    private void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adjRev) {
        vis[node] = 1;

        for (Integer it : adjRev.get(node)) {
            if (vis[it] == 0) {
                dfs2(it, vis, adjRev);
            }
        }
    }
}
