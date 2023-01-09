#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
  public:
    vector<int> ans;
    vector<int> preorderTraversal(TreeNode *root) {
        findPreorder(root);
        return ans;
    }

    void findPreorder(TreeNode *root) {
        if (root == nullptr)
            return;

        ans.push_back(root->val);
        findPreorder(root->left);
        findPreorder(root->right);
    }
};