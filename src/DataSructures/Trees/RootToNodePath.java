package DataSructures.Trees;

import java.util.ArrayList;

public class RootToNodePath {
    
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;

        helper(A, B, ans);
        return ans;
    }

    private boolean helper(TreeNode node, int b, ArrayList<Integer> ans) {

        if (node == null) return false;

        ans.add(node.val);
        if (node.val == b) {
            return true;
        }
        if (helper(node.left, b, ans) || helper(node.right, b, ans) == true) return true;
        // backtrack
        ans.remove(ans.size() - 1); 
        return false;
    }
}
