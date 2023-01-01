#include <bits/stdc++.h>
using namespace std;

// leetcode: https://leetcode.com/problems/unique-paths-iii/
class Solution {
  public:
    int dfs(vector<vector<int>> &grid, int row, int col, int &countZero) {

        // if any of these happen simply return.
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid[0].size() || grid[row][col] == -1) {
            return 0;
        }

        if (grid[row][col] == 2) {
            return countZero == 0 ? 1 : 0;
        }

        grid[row][col] = -1;
        countZero--;

        int totalPaths = dfs(grid, row - 1, col, countZero) + dfs(grid, row + 1, col, countZero) + dfs(grid, row, col + 1, countZero) + dfs(grid, row, col - 1, countZero);

        // backtrack.
        grid[row][col] = 0;
        countZero++;

        return totalPaths;
    }

    int uniquePathsIII(vector<vector<int>> &grid) {
        int countZero = 1; // since we should take the starting cell also in the consideration.
        // starting x and y cordinates.
        int sx = -1;
        int sy = -1;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 0)
                    countZero++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }

        return dfs(grid, sx, sy, countZero);
    }
};