#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int maxIceCream(vector<int> &costs, int coins) {
        int n = costs.size();
        int maxi = 0;
        sort(costs.begin(), costs.end());
        int ind = 0;
        // keep on buying until te coins > 0
        while (coins > 0 && ind < n) {
            int costIceCream = costs[ind++];
            if (coins >= costIceCream) {
                maxi++;
                coins -= costIceCream;
            } else {
                break;
            }
        }
        return maxi;
    }
};