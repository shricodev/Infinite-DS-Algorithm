package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfsGraph
 */
public class BfsGraph {

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
        System.out.println(bfsOfGraph(v, adj));
    }

    // time complexity; O(n) + O(2E)
    // space complexity: O(3n)
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while (!q.isEmpty()) {
            // .poll() method returns and removes the element so no need to pop.
            Integer node = q.poll();
            bfs.add(node);
            
            for(Integer it : adj.get(node)) {
                if (!vis[it]) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        return bfs;
    }
}