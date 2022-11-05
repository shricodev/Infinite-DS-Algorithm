package DataSructures.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val) {this.val = val;};
    TreeNode() {;}
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class IterativeInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.add(node);
                node = node.left;
            }
            else { // if the node is null
                if (st.isEmpty()) {
                    break;
                } 
                node = st.peek();
                st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;

        
    }
}
