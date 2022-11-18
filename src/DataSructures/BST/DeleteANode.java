package DataSructures.BST;

public class DeleteANode {
    
    // problem link: https://leetcode.com/problems/delete-node-in-a-bst/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // then just connect the root.left.right to the root.right.
        if (root.val == key) return helper(root);

        TreeNode curr = root;

        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else curr = curr.left;
            }
            else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else curr = curr.right;
            }
        }

        return root;
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }
        TreeNode rightChild = root.right;
        // we will have to find the right most child in the left most subtree.
        TreeNode lastRight = findRightMost(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public TreeNode findRightMost(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findRightMost(node.right);
    } 
}
