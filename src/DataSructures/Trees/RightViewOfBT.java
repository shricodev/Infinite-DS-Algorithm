package DataSructures.Trees;


import java.util.ArrayList;


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
    int level;
    TreeNode node;
    public Pair(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}
public class RightViewOfBT {
    
    static ArrayList<Integer> bottomView(TreeNode root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        findRightView(root, 0, ans);
        return ans;
    }

    // the idea is since we need the right view so we first go the right, and if the level is equals to ans.size then we add
    // since we know from each level we need to take a single node.
    private static void findRightView(TreeNode node, int level, ArrayList<Integer> ans) {
        if (node == null) return;
        // this is such a smart idea.
        if (level == ans.size()) ans.add(node.val);
        if (node.right != null) findRightView(node.right, level + 1, ans);
        if (node.left != null) findRightView(node.left, level + 1, ans);
    }
}
