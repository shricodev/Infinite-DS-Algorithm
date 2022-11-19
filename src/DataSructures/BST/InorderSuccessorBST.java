package DataSructures.BST;

public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode toFind) {
        // add code here.
        TreeNode successor = null;

        while (root != null) {
            if (toFind.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
