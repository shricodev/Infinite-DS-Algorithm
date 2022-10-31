package ImpAlgorithms.Graphs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class KahnAlgorithmBFS {

    public static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[v];

        // for finding the indegree of the nodes.
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // since this is a directed acyclic graph , so there is for sure a node with no
        // indegree.
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[v];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i] = node;
            i++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        return topo;
    }
}
