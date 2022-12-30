#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    bool checkValidString(string s) {
        stack<char> st;
        unordered_map<char, int> uMap = {{'(', -1}, {'{', -2}, {'[', -3}, {')', 1}, {'}', 2}, {']', 3}};

        for (char bracket : s) {
            if (uMap[bracket] < 0) {
                st.push(bracket);
            } else {
                if (st.empty())
                    return false;
                char c = st.top();
                st.pop();
                if (uMap[bracket] + uMap[c] != 0)
                    return false;
            }
        }

        if (st.empty())
            return true;
        return false;
    }
};

int main() {
    Solution sl;
    cout << sl.checkValidString("(){{{{") << endl;
}