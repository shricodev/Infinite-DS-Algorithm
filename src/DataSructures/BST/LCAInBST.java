package DataSructures.BST;

public class LCAInBST {
    // time complexity: O(height) -> not recommended to use the BT way of solving, since it gives tc of O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findNode(root, p, q);
        return lca;
    }

    private TreeNode findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        while (root != null) {

            // this ensures that we reach the lca. Using the property of BST
            if (root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) {
                return root;
            }

            // if root.val is greater than max of both then we know it is in the left.
            if (root.val >= Math.max(p.val, q.val)) {
                root  = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}