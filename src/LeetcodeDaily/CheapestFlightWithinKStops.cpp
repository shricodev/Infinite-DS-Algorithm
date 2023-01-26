#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int findCheapestPrice(int n, vector<vector<int>> &flights, int src, int dst, int k) {

        vector<vector<pair<int, int>>> adj(n);

        // src - {dest, money}
        for (auto &it : flights) {
            adj[it[0]].push_back({it[1], it[2]});
        }

        // node, price
        queue<pair<int, int>> q;
        vector<int> priceToReach(n, 1e9);
        q.push({src, 0});
        priceToReach[src] = 0;
        int stops = 0;

        while (!q.empty() && stops <= k) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                pair<int, int> curr = q.front();
                q.pop();
                int currNode = curr.first;
                int currPrice = curr.second;

                for (auto &it : adj[currNode]) {

                    int neighbour = it.first;
                    int travelCost = it.second;

                    if (priceToReach[neighbour] > currPrice + travelCost) {
                        priceToReach[neighbour] = currPrice + travelCost;
                        // since this is a good path so we can explore more from here.
                        q.push({neighbour, priceToReach[neighbour]});
                    }
                }
            }
            stops++;
        }
        if (priceToReach[dst] == 1e9)
            return -1;
        return priceToReach[dst];
    }
};