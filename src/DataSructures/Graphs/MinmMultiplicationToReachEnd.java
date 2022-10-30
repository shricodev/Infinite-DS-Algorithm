package DataSructures.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int steps;
    int node;
    public Pair (int steps, int node) {
        this.steps = steps;
        this.node = node;
    }
}

public class MinmMultiplicationToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair> q = new LinkedList<>();
        int n = 100000;
        // since we can have a total node of 9999 since mod of 100000, given in the constraints.
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        int mod = (int) 1e5;
        dist[start] = 0;
        q.add(new Pair(0, start));

        while (!q.isEmpty()) {
            int steps = q.peek().steps;
            int node = q.peek().node;
            q.remove();
            for (int i : arr) {
                int num = (i * node) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end) return dist[num];
                    q.add(new Pair(steps + 1, num));
                }
            } 
        }
        return -1;
    }
}
