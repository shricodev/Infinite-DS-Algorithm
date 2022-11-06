package DataSructures.Trees;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val) {this.val = val;};
    TreeNode() {;}
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CheckBalancedBT {

    boolean isBalanced(TreeNode root) {
        // Your code here
        if (findHeight(root) == -1) return false;
        return true;
    }

    // this is the same fxn to find the maxm height of the tree. just modified.
    // if the tree is balanced then it returns the max height. else it returns -1
    // if the diff of max height of the left and right exceeds -1 for any node, then there is no need to check for the further down node
    public int findHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHt = 1 + findHeight(node.left);
        if (leftHt == -1) return -1;
        int rightHt = 1 + findHeight(node.right);
        if (rightHt == -1) return -1;
        if (Math.abs(leftHt - rightHt) > 1)
            return -1;
        return Math.max(leftHt, rightHt);
    }
}
