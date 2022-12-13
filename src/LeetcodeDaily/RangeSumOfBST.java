package LeetcodeDaily;

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

    public int efficientSolve(TreeNode node, int low, int high) {
        if (node == null) return 0;
        
        // if the node val is betwee of the low and high, then we need to go both the ways.
        if (node.val >= low && node.val <= high) {
            return node.val + efficientSolve(node.left, low, high) + efficientSolve(node.right, low, high);
        }

        // else if the node val is greater than the high then we go left.
        if (node.val > high) {
            return efficientSolve(node.left, low, high);
        } else {
            // else we go right
            return efficientSolve(node.right, low, high);
        }
    }
}