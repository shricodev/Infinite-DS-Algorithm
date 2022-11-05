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

class Pair {
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

// time complexity; O(3n)
// space complexity; O(3n)
public class IterativeAllInOne {

    public void preInPostTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<Pair>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) return;
        // this is the intial configuration. push the root node with val 1.
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair it = st.pop();
            // this condn never hits BTW
            // if (it.num > 3) st.pop();
            if (it.num == 1) {
                preOrder.add(it.node.val);
                it.num++;
                st.push(it);
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            else if (it.num == 2) {
                inOrder.add(it.node.val);
                it.num++;
                st.push(it);
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            else if (it.num == 3) {
                postOrder.add(it.node.val);
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }
    
}
