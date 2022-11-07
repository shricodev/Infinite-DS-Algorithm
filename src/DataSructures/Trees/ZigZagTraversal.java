package DataSructures.Trees;

import java.util.ArrayList;
import java.util.Collections;
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

public class ZigZagTraversal {
    

    List<List<Integer>> zigZagTraversal(TreeNode root)
	{
	    //Add your code here.
        List<List<Integer>> ans = new ArrayList<>();
        int level = 1; // odd -> L - R, even  -> R - L
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    temp.add(node.val);
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(temp);
            }
            ans.add(temp);
            level++;
        }
        return ans;
	}
}
