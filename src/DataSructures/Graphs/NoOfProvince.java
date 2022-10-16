package DataSructures.Graphs;

import java.util.ArrayList;

public class NoOfProvince {

    // problem link: https://practice.geeksforgeeks.org/problems/number-of-provinces/1
    // in this question it is given the adjacency matrix than the adjacency list.
    // time complexity; O(n) + O(v + 2E)
    // space complexity: O(n) + O(n)
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<Integer>());
        }

        // now to change the adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {

                if (adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfsFind(i, vis, adjLs);
            }
        }

        return cnt;
    }

    private static void dfsFind(int node, int[] vis, ArrayList<ArrayList<Integer>> adjLs) {
    
        vis[node] = 1;

        for (Integer it : adjLs.get(node)) {
            if (vis[it] == 0) {
                dfsFind(it, vis, adjLs);
            }
        }
    }
}
