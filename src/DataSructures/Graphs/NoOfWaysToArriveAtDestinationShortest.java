package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int first;
    int second;

    public Pair (int first,int second) {
        this.first = first;
        this.second = second;
    }
}


// User function Template for Java

public class NoOfWaysToArriveAtDestinationShortest {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] dis = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        int mod = (int) (1e9 + 7);

        while (pq.size() != 0) {
            int dist = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // arriving at the adjNode for the first time with this short distance.
                if (dist + edW < dis[adjNode]) {
                    dis[adjNode] = dist + edW;
                    pq.add(new Pair(dist + edW, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if (dist + edW == dis[adjNode]) {
                    ways[adjNode] = (ways[node] + ways[adjNode]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}
