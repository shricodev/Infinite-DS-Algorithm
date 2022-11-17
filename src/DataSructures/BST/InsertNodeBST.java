package DataSructures.BST;

public class InsertNodeBST {
    
    // time complexity; O(log2n)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                } else curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                } else curr = curr.left;
            }
        }
        return root;
    }
}
