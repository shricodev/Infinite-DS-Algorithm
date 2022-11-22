package DataSructures.BST;

public class MinmElemInBST {
    // since the leftmost node is always the min.
    int minValue(TreeNode node) {
        if (node == null) return -1;
        int min = Integer.MAX_VALUE;
        while (node != null) {
            min = node.val;
            node = node.left;
        }
        return min;
    }
}
