#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int maxPoints(vector<vector<int>> &points) {
        int n = points.size();
        if (n <= 2)
            return n;
        int maxi = 0;

        // the idea is for every i we find all the point with the same value of angle of i, which means they are in the same line.
        for (int i = 0; i < n; i++) {
            // angle can have decimals so.
            // angle, points lie in that angle.
            unordered_map<double, int> map;

            for (int j = 0; j < n; j++) {
                // we donot want duplicate.
                if (j != i) {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];

                    // theta = tan^-1((y2 - y1) / (x2 - x1)
                    // atan2 : tan^-1
                    auto theta = atan2(dy, dx);
                    map[theta]++;
                }
            }
            // finding the max among all the values.
            for (auto it : map) {
                // + 1 since we are not counting i, so for including i taking + 1
                maxi = max(maxi, it.second + 1);
            }
        }
        return maxi;
    }

    // TC: O(n^3)
    int maxPointsBrute(vector<vector<int>> &points) {
        int n = points.size();
        if (n <= 2)
            return n;
        // the main idea is if two points are on same line then they must have same slope
        int maxi = 0;

        for (int i = 0; i < n; i++) {         // P1(x1, y1)
            for (int j = i + 1; j < n; j++) { // P2(x2, y2)
                int count = 2;                // since P1 and P2 is already included.
                // finding the slope of two point x and y
                int dx1 = points[j][0] - points[i][0]; // x2 - x1
                int dy1 = points[j][1] - points[i][1]; // y2 - y1

                for (int k = 0; k < n; k++) { // P3(x3, y3)
                    // not taking the duplicate cordinates.
                    if (k != i && k != j) {
                        // we can do it with k and j or k and i. since they both will have same slope.
                        int dx2 = points[k][0] - points[i][0]; // x3 - x1
                        int dy2 = points[k][1] - points[i][1]; // y3 - y1
                        if (dy1 * dx2 == dx1 * dy2) {
                            count++;
                        }
                    }
                }
                maxi = max(maxi, count);
            }
        }
        return maxi;
    }
};