package ImpAlgorithms.Graphs;

import java.util.ArrayList;
import java.util.Stack;

//* TOPOLOGICAL sorting works on Direct Acyclic Graph only. it is the opposite of DFS
public class TopologicalSortingDFS {
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, st, vis);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            // we need to remove the elements as we go since we are storing elem from top to bottom
            st.pop();
        }
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, boolean[] vis) {

        vis[node] = true;

        for (Integer adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfs(adj, adjNode, st, vis);
            }
        }
        // when the topo sort is done for the node, we add it to the stack
        st.add(node);
    }
}
