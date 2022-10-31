package DataSructures.Graphs;

public class CityWithSmallestNeighbourWithinThreshold {

    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        for (int[] is : dist) {
            int u = is[0];
            int v = is[1];
            int wt = is[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // distance from the node to node is 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // now applying the floyd warshall algorithm
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // it means it is not reachable.
                    if (dist[i][via] == (int) 1e9 || dist[via][j] == (int) 1e9) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        // main qn
        int cntCity = (int) 1e9;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }

            // even if the cntCity for some city is same as the other, it should store the > city no.
            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
