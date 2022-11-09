package DataSructures.Trees;

public class SymmetricTree {
    
    public static boolean isSymmetric(Node root)
    {
        // add your code here;

        if (root == null) return true;
        // check for the symmetry in the left and right subtree
        return helper(root.left, root.right);
    }

    private static boolean helper(Node left, Node right) {
        // base case.
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;

        if (left.data != right.data) {
            return false;
        }

        // check for the mirror of each node.
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
