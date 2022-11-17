package DataSructures.BST;

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

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public TreeNode searchBSTrec(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        // if the val is lesser than the node val then go to the left side to check or else go to the right side.
        if (val < node.val) return searchBST(node.left, val);
        return searchBST(node.right, val);
    }
}
