package DataSructures.BST;

public class CheckValidBST {
    public boolean isValidBST(TreeNode root) {
 		if (root == null) return true;
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, long lowLimit, long highLimit) {

        if (root == null) return true;

        // for left checks,          for right checks
        if (root.val >= highLimit || root.val <= lowLimit) return false;
        
        return isBST(root.left, lowLimit, root.val) && isBST(root.right, root.val, highLimit);
    }
}