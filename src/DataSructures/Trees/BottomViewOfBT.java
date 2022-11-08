package DataSructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

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
    int vertical;
    TreeNode node;
    public Pair(int vertical, TreeNode node) {
        this.vertical = vertical;
        this.node = node;
    }
}

public class BottomViewOfBT {
    static ArrayList<Integer> bottomView(TreeNode root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if (root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int vertical = temp.vertical;
            TreeNode node = temp.node;

            // since we are traversing level order wise, so the last level nodes will be in the top of the queue and be replaced.
            map.put(vertical, node.val);

            if (node.left != null) {
                q.add(new Pair(vertical - 1, node.left));
            }
            if (node.right != null) {
                q.add(new Pair(vertical + 1, node.right));
            }
        }

        for (int nodes : map.values()) {
            ans.add(nodes);
        }
        return ans;
    }
}
