package DataSructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

/**
 * BfsTraversalOfBinaryTree
 */
public class BfsTraversalOfBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            int node = q.peek().val;
            q.remove();
            List<Integer> subAns = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                subAns.add(node);
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
            }
            ans.add(subAns);
        }
        return ans;
    }
    
}