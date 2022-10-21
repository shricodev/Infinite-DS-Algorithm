package DataSructures.Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedBFSKahn {
    

    public static boolean topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

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
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            count++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        // if the topological sort has the same no of the element then it means that the 
        // sort was successful and it is the acyclic graph.
        if (count == v) {
            return false;
        }
        return true;
    }
}
