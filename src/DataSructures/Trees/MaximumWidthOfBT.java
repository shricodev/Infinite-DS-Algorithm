package DataSructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int ind;
    public Pair(TreeNode node, int ind) {
        this.node = node;
        this.ind = ind;
    }
}

public class MaximumWidthOfBT {
    
    // this is the leetcode version of the question and not the GFG, the question on the GFG varies from the leetcode one.
    // since we are assigning the indexes so it takes care of even the null nodes.
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        long maxi = 0;
        while (!q.isEmpty()) {
            int levelNum = q.size();
            long startElem = q.peek().ind;
            long backElemInd = 0;

            for (int i = 0; i < levelNum; i++) {
                Pair it = q.poll();
                TreeNode node = it.node;
                int ind = it.ind;
                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * ind + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * ind + 2));
                }
                if (i == levelNum - 1) {
                    backElemInd = it.ind;
                }
            }
            // since we do not have a function to find the back element of the queue, so we need to 
            // update it when we reach the last index.
            maxi = Math.max(maxi, backElemInd -  startElem + 1);
        }
        return (int) maxi;
    }
}
