package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStatesTopologicalSortKahn {

    // so this can be confusing in the future, to understand link:
    // https://www.youtube.com/watch?v=2gtg3VsDGyc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=25
    public List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[v];
        // reversing the adjacent list, which makes sure that the part connected to the
        // cycle in a graph is never traversed.
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                // it -> i this time and not i -> it
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);

            for (Integer it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }
}
