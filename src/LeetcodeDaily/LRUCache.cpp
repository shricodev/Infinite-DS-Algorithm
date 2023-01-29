#include <bits/stdc++.h>
using namespace std;

// this is the brute force soln to the problem
class LRUCache {
  public:
    vector<pair<int, int>> lru;
    int n;
    LRUCache(int capacity) {
        n = capacity;
    }

    int get(int key) {

        for (int i = 0; i < lru.size(); i++) {

            if (lru[i].first == key) {
                int val = lru[i].second;
                // storing the val in temp to push it forward.
                pair<int, int> temp = lru[i];
                // erase the val.
                lru.erase(lru.begin() + i);
                lru.push_back(temp);

                return val;
            }
        }
        return -1;
    }

    void put(int key, int value) {

        for (int i = 0; i < lru.size(); i++) {

            if (lru[i].first == key) {
                lru.erase(lru.begin() + i);
                lru.push_back({key, value});
                return;
            }
        }

        if (lru.size() == n) {
            lru.erase(lru.begin());
            lru.push_back({key, value});
            return;
        }
        lru.push_back({key, value});
        return;
    }
};
