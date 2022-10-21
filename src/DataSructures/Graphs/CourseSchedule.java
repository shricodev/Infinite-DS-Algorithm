package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    static int[] findOrder(int v, int m, ArrayList<ArrayList<Integer>> prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
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
        // if the topological sort has the same no of the element then it means that the 
        // sort was successful and it is the acyclic graph.
        if (i == v) {
            return topo;
        }
        int[] temp = {};
        return temp;
    }
}
