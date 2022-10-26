package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair {

    int v;
    int wt;
    public Pair (int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

public class ShortestPathDAGTopo {
    
    // time complexity: O(n + e), whichi is better than the dijkstra algorithm
    // we use hte topo sort, since we need to move to the edges acc to the reachability
    public int[] shortestPath(int n, int m, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // filling the arraylis with the empty arraylist first.
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // creating the adjacency list.
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);

        // src is always the 0 node, given.
        dis[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            // if the distance of the node is ie9 then no need to check for the adj node from that node.
            if (dis[node] != (int) 1e9) {
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).v;
                    int wt = adj.get(node).get(i).wt;
    
                    if (dis[v] > dis[node] + wt) {
                        dis[v] = dis[node] + wt;
                    }
                }
            }
        }
        // if at the last also the distance if equal to 1e9 means it is not possible to reach that node, so make it -1.
        for(int i = 0; i < dis.length; i++) {
            if (dis[i] == 1e9) {
                dis[i] = -1;
            }
        }
        return dis;
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st) {
    
        vis[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).v;
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
}
