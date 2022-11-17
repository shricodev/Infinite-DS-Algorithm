package DataSructures.Trees;

import java.util.ArrayList;

public class MorrisTraversal {
    // for reference in future: https://youtu.be/2BdY9fixMrM?t=208
    public ArrayList<Integer> getInorder(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        // created a copy curr node of root, we dont want to destroy the root node.
        TreeNode curr = root;
        while (curr != null) {
            // if left node is null then just add it and move to the right subtree.
            if (curr.left == null) {
                inorder.add(curr.left.val);
                curr = curr.right;
            } else {
                // the temp node is going to store the right most node in the left subtree.
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                // if right is equals to null, then it means it is the rightmost node in the left subtree. so connect it to the curr node.
                // and then move to the left node since we need to return as well so making the connection.
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                }
                else {
                    // removing the connection  
                    predecessor.right = null;
                    // for preorder traversal just shift this add line to the if statement.
                    inorder.add(predecessor.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}
