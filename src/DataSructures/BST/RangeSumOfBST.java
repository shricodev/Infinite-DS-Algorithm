package DataSructures.BST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum  = new int[1];
        inorderBST(root, sum, low, high);
        return sum[0];
    }

    public void inorderBST(TreeNode node, int[] sum, int low, int high) {
        if (node == null) return;

        inorderBST(node.left, sum, low, high);
        
        if (node.val >= low && node.val <= high) {
            sum[0] += node.val;
        }
        inorderBST(node.right, sum, low, high);
    }
}