#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int findMinArrowShots(vector<vector<int>> &points) {
        int n = points.size();
        if (n == 1)
            return 1;
        int arrows = 1;

        sort(points.begin(), points.end());
        vector<int> prev = points[0];

        for (int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][0];

            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];
            // if no overlap
            if (currStartPoint > prevEndPoint) {
                arrows++;
                prev = points[i];
            } else {
                // if overlap then we will find the intersection point of the curr and prev .
                prev[0] = max(prevStartPoint, currStartPoint);
                prev[1] = min(currEndPoint, prevEndPoint);
            }
        }
        return arrows;
    }
};