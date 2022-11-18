package DataSructures.BST;

class Solution {
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        findKSmall(root, k, ans);
        return ans[0];
    }

    // Another approach: we can like store all the inorder and take the kth - 1 elem, but why do that when we can modify the code a little bit.
    // if asked bout kth largest, then ans is (no of nodes - kth smallest) + 1
    // or do the right, root, left in the same way.
    private void findKSmall(TreeNode node, int k, int[] ans) {
        if (node == null) {
            return;
        }

        findKSmall(node.left, k, ans);

        if (++count == k) {
            ans[0] = node.val;
            return;
        }

        findKSmall(node.right, k, ans);
    }
}
