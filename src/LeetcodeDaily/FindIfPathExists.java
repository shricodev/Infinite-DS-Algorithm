package LeetcodeDaily;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExists {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1,2}, {2,0}};
        System.out.println(validPath(3, edges, 0, 2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] vis = new int[n];

        // creating the adjacency list.
        for (int[] list : edges) {
            int u = list[0];
            int v = list[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(source, destination, adj, n, vis);
    }

    private static boolean dfs(int node, int destination, List<List<Integer>> adj, int n, int[] vis) {

        vis[node] = 1;
        
        if (node == destination) {
            return true;
        }

        for(Integer it : adj.get(node)) {
            if (vis[it] == 0 && dfs(it, destination, adj, n, vis)) {
                return true;
            }
        } 

        return false;
    }
}
