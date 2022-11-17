package DataSructures.Trees;

import java.util.Stack;

public class FlattenBTtoLLStack {
    
    // this is the iterative soln of the recursive soln of the qn.
    public void flatten(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.right != null) {
                st.add(node.right);
            }
            if (node.left != null) {
                st.add(node.left);
            }
            if (!st.isEmpty()) {
                node.right = st.peek();
            }
            node.left = null;
        }
    }
}
