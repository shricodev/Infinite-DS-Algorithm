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
public class LevelOrderTraversalOfBT {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subAns = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.poll();
                subAns.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(subAns);
        }
        return ans;
    }
    
}