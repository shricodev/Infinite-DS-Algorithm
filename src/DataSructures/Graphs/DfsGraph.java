package DataSructures.Graphs;

import java.util.ArrayList;


public class DfsGraph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int v = 5;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        System.out.println(dfsGraph(v, adj));

    }

    public static ArrayList<Integer> dfsGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[v];
        ArrayList<Integer> dfs = new ArrayList<>();
        int start = 0;
        dfsFind(start, vis, adj, dfs);
        return dfs;
    }

    // time complexity: O(n) + o(2E)
    // space complexity: O(n)-> dfs + O(n) -> vis + O(n) -> stack space => O(n)
    private static void dfsFind(int node, boolean[] vis,
                                ArrayList<ArrayList<Integer>> adj,
                                 ArrayList<Integer> dfs) {
    
        dfs.add(node);
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfsFind(it, vis, adj, dfs);
            }
        }
    }
}
