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
    bool sameTree(TreeNode *p, TreeNode *q) {

        if (p == NULL && q != NULL || q == NULL && p != NULL)
            return false;

        if (p == NULL && q == NULL)
            return true;

        return p->val == q->val && sameTree(p->left, q->left) && sameTree(p->right, q->right);
    }
    bool isSameTree(TreeNode *p, TreeNode *q) {
        return sameTree(p, q);
    }
};

// BFS approach
class Solution1 {
  public:
    bool isSameTree(TreeNode *p, TreeNode *q) {
        if (p == NULL && q == NULL)
            return true;

        // if any one of them is null
        if (p == NULL || q == NULL)
            return false;
        queue<TreeNode *> q1;
        queue<TreeNode *> q2;
        q1.push(p);
        q2.push(q);
        while (!q1.empty() && !q2.empty()) {
            TreeNode *first = q1.front();
            TreeNode *second = q2.front();
            q1.pop();
            q2.pop();
            if (first->val != second->val)
                return false;

            if (first->left && second->left) {
                q1.push(first->left);
                q2.push(second->left);
            } else if (first->left || second->left)
                return false;

            if (first->right && second->right) {
                q1.push(first->right);
                q2.push(second->right);
            } else if (first->right || second->right)
                return false;
        }
        return true;
    }
};