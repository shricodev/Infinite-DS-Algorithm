package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    
    public String findOrder(String[] dict, int n, int k)
    {
        // Write your code here
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            
            String s1 = dict[i];
            String s2 = dict[i+1];
            int length = Math.min(s1.length(), s2.length());

            // creating the adjacency list.
            // iterating over the characters.
            for (int j = 0; j < length; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = new ArrayList<>();
        topoSort(topo, adjList, k);

        String ans = "";
        for (int i : topo) {
            ans = ans + (char)(i + (int)'a');
        }
        return ans;
    }

    private void topoSort(List<Integer> topo, List<List<Integer>> adjList, int k) {

        int[] indegree = new int[k];
        
        for (int i = 0; i < k; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
    }
}
