#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int n = gas.size();
        int total_fuel = 0;
        int total_cost = 0;

        for (int i = 0; i < n; i++) {
            total_cost += cost[i];
            total_fuel += gas[i];
        }

        if (total_cost > total_fuel)
            return -1;

        int start = 0;
        int remains_gas = 0;

        // now we donot need to traverse the array circular manner, since we know there is hundred percent an answer here is the above condn is not executed so if we can reach to the end of the array from any index then that is the answer. since at any point it didn't give -ve which means there were +ve values contributing to the ans.
        for (int i = 0; i < n; i++) {
            remains_gas += gas[i] - cost[i];
            if (remains_gas < 0) {
                start = i + 1;
                remains_gas = 0;
            }
        }
        return start;
    }

    // brute force code. O(n^2 + n)
    int canCompleteCircuitBrute(vector<int> &gas, vector<int> &cost) {
        int n = gas.size();
        long long total_cost = 0;
        long long total_fuel = 0;

        for (int i = 0; i < n; i++) {
            total_cost += cost[i];
            total_fuel += gas[i];
        }

        if (total_cost > total_fuel)
            return -1;

        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i])
                continue;

            int j = (i + 1) % n;

            int curr_gas = gas[i] - cost[i] + gas[j];

            while (j != i) {
                if (curr_gas < cost[j])
                    break;

                int travel_cost = cost[j];
                j = (j + 1) % n;
                int gas_earned = gas[j];
                curr_gas = curr_gas - travel_cost + gas_earned;
            }
            if (j == i) {
                return i;
            }
        }
        // this line probably wont execute since we have already handled the case of only -1 earlier.
        return -1;
    }
};