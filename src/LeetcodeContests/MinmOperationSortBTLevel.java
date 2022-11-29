package LeetcodeContests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    int num;
    int ind;
    public Pair(int num,  int ind) {
        this.num = num;
        this.ind = ind;
    }
}

public class MinmOperationSortBTLevel {

    // the idea is the min swap to reach the sorted array of the level is == min swap to reach the level node from the sorted array.
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        // level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = 0;
            // this stores nodes of each level.
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    level.add(node.right.val);
                }
            }
            ans += minSwaps(level);
        }
        return ans;
    }

    private int minSwaps(ArrayList<Integer> level) {
        ArrayList<Pair> pos = new ArrayList<>();
        for (int i = 0; i < level.size(); i++) {
            pos.add(new Pair(level.get(i), i));
        }
        int ans = 0;
        // * NOTE: dont know how to sort a pair class arraylist so find a way to sort the pair class arraylsit.
        // Collections.sort(pos);
        for (int i = 0; i < level.size(); i++) {
            if (pos.get(i).ind == i) {
                continue;
            }
            while (pos.get(i).ind != i) {
                ans++;
                swap(pos.get(i), pos.get(pos.get(i).ind));
            }
        }
        return ans;
    }

    private void swap(Pair pair, Pair pair2) {
        Pair temp = pair;
        pair = pair2;
        pair2 = temp;
    }
}
