package ImpAlgorithms.Graphs;

public class FloydWarshall {

    // time complexity; O(n^3)
    // space complexity; O(n^2) -> since we are modifying the given matrix.
    // ! NOTE: if no negative wt is given, then we can use the dijkstra algorithm
    // ! for all the nodes, individually which reduces the time complexity to V *
    // ! (ElogV) iff E < V^2
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
                // distance from the node to node is always 0
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }

        // for finding the negative cycle
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                System.out.println("negative cycle present.");
            }
        }

    }
}
