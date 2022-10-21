package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// GFG problem link: https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1
// this is basically a problem which has to deal with the cycle of the graph, taking the task as u and the prerequisite as v.
// to perform task u task v should be done first. so using the topological sort using the kahn's algorithm can also be done using the DFS method.
// if the cycle is found in the graph then the ans would be false, that is we would not be able to complete all the tasks.
public class PrerequisiteTasks {
    
    public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
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
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return (N == count) ? true : false;


    }
}
