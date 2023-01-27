#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    bool isConcatenated(string word, unordered_set<string> &st) {
        int n = word.length();

        for (int i = 0; i < n; i++) {
            string prefix = word.substr(0, i + 1);
            string suffix = word.substr(i + 1, n);

            // if the suffix and prefix are both in the array in 2 pieces.    if the prefix is in one piece and suffix is in multiple pieces.
            if (st.find(prefix) != st.end() && st.find(suffix) != st.end() || st.find(prefix) != st.end() && isConcatenated(suffix, st)) {
                return true;
            }
        }
        return false;
    }

    vector<string> findAllConcatenatedWordsInADict(vector<string> &words) {
        int n = words.size();
        unordered_set<string> st(begin(words), end(words));
        vector<string> ans;
        // iterate over each word and check if it is concatenated.
        for (int i = 0; i < n; i++) {
            string word = words[i];

            if (isConcatenated(word, st)) {
                ans.push_back(word);
            }
        }
        return ans;
    }
};