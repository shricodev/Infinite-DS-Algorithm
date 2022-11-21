package DataSructures.BST;

import java.util.Stack;

// Storing the inorder and iterating will have a time complexity of the O(n), O(H) is expected.
public class BSTIterator {

    Stack<TreeNode> st = new Stack<>();
    // at first we push all the left nodes in the stack.
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        // if asked next we take the uppermost node and remove it while adding all the right nodes.
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        if (!st.isEmpty()) return true;
        return false;
    }

    // this adds all the left nodes from the node.
    public void pushAll(TreeNode node) {
        while (node != null) {
            st.add(node);
            node = node.left;
        }
    } 
}
