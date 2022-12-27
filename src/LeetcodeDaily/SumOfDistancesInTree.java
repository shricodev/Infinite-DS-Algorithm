package LeetcodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfDistancesInTree {

    static int rootSum = 0;
    static int N;

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {2, 3},
            {2, 4},
            {2, 5},
        };
        System.out.println(Arrays.toString(sumOfDistancesInTree(n, edges)));
    }


    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        int[] count = new int[N];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // taking the root node as 0.
        dfsRoot(adj, 0, -1, 0, count);

        int[] result = new int[N];
        result[0] = rootSum;

        // could have done 1 but 0 works fine
        dfs(result, adj, 0, -1, count);

        return result;
    }

    private static void dfs(int[] result, List<List<Integer>> adj, int parent, int prevNode, int[] count) {

        for (int child : adj.get(parent)) {
            if (child == prevNode) continue;
            // this is the formula to calculate the sum for each node. but for this we need to find athe sum of its parent so calculated for 0 with dfsRoot method.
            result[child] = result[parent] - count[child] + (N - count[child]);
            dfs(result, adj, child, parent, count);
        }
    }

    // this is the method to find the count of all the subtrees for each node including the node. and sum of the root node.
    private static int dfsRoot(List<List<Integer>> adj, int currNode, int prevNode, int currDepth, int[] count) {

        // it is the count of the childs including the node itself.
        int totalNode = 1;

        rootSum += currDepth;

        for (int child : adj.get(currNode)) {
            if (child == prevNode) continue;
            totalNode += dfsRoot(adj, child, currNode, currDepth + 1, count);
        }

        count[currNode] = totalNode;

        return totalNode;
    }
}
