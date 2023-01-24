#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    // this finds the row and col to the provided no.
    pair<int, int> findCordinate(int number, int n) {
        int row = n - (number - 1) / n - 1;
        int col = (number - 1) % n;
        // *note: if both n and row is even then it is going right to left else left to right.
        // *or both are odd.(n and row.)
        if (row % 2 == n % 2) {
            return {row, n - 1 - col};
        } else {
            return {row, col};
        }
    }

    int snakesAndLadders(vector<vector<int>> &board) {
        int n = board.size();
        int steps = 0;
        vector<vector<bool>> vis(n, vector<bool>(n, false));
        queue<int> q;
        q.push(1);
        vis[n - 1][0] = true;

        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int number = q.front();
                q.pop();
                if (number == n * n)
                    return steps;

                for (int dice = 1; dice < 7; dice++) {
                    if (dice + number > n * n)
                        break;
                    pair<int, int> cordinate = findCordinate(number + dice, n);
                    int row = cordinate.first;
                    int col = cordinate.second;
                    if (vis[row][col] == true)
                        continue;
                    vis[row][col] = true;
                    if (board[row][col] != -1) {
                        // snake or ladder.
                        q.push(board[row][col]);
                    } else {
                        q.push(number + dice);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
};