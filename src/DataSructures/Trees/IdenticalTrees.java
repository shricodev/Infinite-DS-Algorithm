package DataSructures.Trees;

// import java.util.ArrayList;
// import java.util.Stack;

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

public class IdenticalTrees {
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // * brute soln, that came to my mind 
        // * this code works but when we encounter null as node val, it fails. Will modify this in future.
        // if (p == null && q == null) return true;
        // ArrayList<Integer> guide = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();  
        // st.add(p);
        // for the root node p
        // while (!st.isEmpty()) {
        //     TreeNode node = st.pop();
        //     guide.add(node.val);
        //     if (node.right != null) st.add(node.right);
        //     if (node.left != null) st.add(node.left);
        // }

        // st.add(q);
        // int counter = 0;
        // while (!st.isEmpty()) {
        //     TreeNode node = st.pop();
        //     if (guide.get(counter) != node.val) return false;
        //     if (node.right != null) st.add(node.right);
        //     if (node.left != null) st.add(node.left);
        //     counter++;
        // }

        // return true;
        
        // * short and crisp code, learned from striver.
        // if either of one is null and other is not null
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        // if both are null, then they are same.
        if (p == null && q == null) return true;

        return (p.val == q.val) && isSameTree(p.left,  q.left) && isSameTree(p.right,  q.right);
    }
}
