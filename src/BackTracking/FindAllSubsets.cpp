#include <bits/stdc++.h>
using namespace std;

// using set instead of vector<vector<int>> since if there are even duplicate elem in the given vector, then we will not get duplicate subset.
unordered_set<vector<int>> ans;

void findSubset(vector<int> &set, vector<int> &curr, int ind) {
    if (ind == set.size()) {
        ans.insert(curr);
        return;
    }
    // not take.
    findSubset(set, curr, ind + 1);

    // take.
    curr.push_back(set[ind]);
    findSubset(set, curr, ind + 1);

    // backtrack.
    // since we are passing the curr by reference so we need to remove the element before returning.
    curr.pop_back();
}

int main() {
    vector<int> set = {1, 3, 5, 7, 8};
    vector<int> currSubset;
    findSubset(set, currSubset, 0);
}