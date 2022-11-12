package DataSructures.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PrintAllNodeAtDisK {
    
    // time complexity: O(n) + O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target, true);
        int currLvl = 0;
        // this loop will break, even before the q is empty, since at last it will store all the ans which are yet to be taken out.
        while (!q.isEmpty()) {
            int size = q.size();
            if (currLvl == k) break;
            currLvl++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                // if the parent of the node is not visited then we can go there as well since we can move in three directions with the help of the parent hashmap.
                if (parents.get(node) != null && visited.get(parents.get(node)) == null) {
                    q.add(parents.get(node));
                    visited.put(parents.get(node), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
        
    }

    private void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                parents.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                parents.put(node.right, node);
            }
        }
    }
}
