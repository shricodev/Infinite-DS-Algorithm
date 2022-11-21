package DataSructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    };

    TreeNode() {
        ;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(TreeNode root) {
        // add your code here
        // assigning verticals as: .... -2 -1 0 1 2 ....
        // levels increase by +1 for each depth
        ArrayList<Integer> ans = new ArrayList<>();
        // for leetcode ,we should take the PriorityQueue inside or sort it. but for GFG it works fine.
        //      vertical,       level,              nodes
        // since the treemap stores the keys sorted we will get the ans as required (vertical from low to high).
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        if (root == null) return ans;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            TreeNode node = q.peek().node;
            int vertical = q.peek().vertical;
            int level = q.peek().level;
            q.remove();
            map.putIfAbsent(vertical, new TreeMap<>());
            map.get(vertical).putIfAbsent(level, new ArrayList<>());
            map.get(vertical).get(level).add(node.val);
            if (node.left != null) {
                q.add(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, vertical + 1, level + 1));
            }

        }
        for (TreeMap<Integer, ArrayList<Integer>> ls : map.values()) {
            for (ArrayList<Integer> nodes : ls.values()) {
                for(int i = 0; i < nodes.size(); i++) {
                    ans.add(nodes.get(i));
                }
            }
        }
        return ans;
    }
}
