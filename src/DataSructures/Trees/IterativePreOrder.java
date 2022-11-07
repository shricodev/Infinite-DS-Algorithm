package DataSructures.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// TC: O(n)
public class IterativePreOrder {
    public List<Integer> preOrderTraversal(Node node) {
        List<Integer> ans = new ArrayList<>();
        if (node == null) return ans;
        Stack<Node> st = new Stack<>();
        st.add(node);
        while (!st.isEmpty()) {
            node = st.peek();
            st.pop();
            ans.add(node.data);
            // we are pushing the right node first, bcuz we know the stackis LIFO so we want to go in -> ROOT LEFT RIGHT
            if (node.right != null)
                st.add(node.right);
            if (node.left != null)
                st.add(node.left);
        }
        return ans;
    }
}
