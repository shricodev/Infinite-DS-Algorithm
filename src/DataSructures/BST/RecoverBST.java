package DataSructures.BST;

public class RecoverBST {

    private TreeNode prev;
    private TreeNode first;
    // middle is required if the two violated nodes are adjacent then it will not work.
    private TreeNode middle;
    private TreeNode last;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        recover(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public void recover(TreeNode node) {
        if (node == null) return;

        recover(node.left);
        
        // means there is a violation.
        if (node.val < prev.val) {

            // if its the first violation
            if (first == null) {
                first = prev;
                middle = node;
            }
            // if it is the second violation
            else last = node;
        }
        
        // when moving forward mark the current node as the prev for another call.
        prev = node;
        recover(node.right);
    }
}