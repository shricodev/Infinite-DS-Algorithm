#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool detectCapitalUse(string word) {
        int count_capital = 0;
        int n = word.size();
        for(int i = 0; i < n; i++) {
            if (word[i] >= 'A' && word[i] <= 'Z') count_capital++;
        }

        if (count_capital == 0 || count_capital == n) return true;
        if (count_capital == 1 && word[0] >= 'A' && word[0] <= 'Z') return true;
        return false;
    }
};