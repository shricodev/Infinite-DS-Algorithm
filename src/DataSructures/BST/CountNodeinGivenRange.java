package DataSructures.BST;

public class CountNodeinGivenRange {
    
    int getCount(TreeNode root,int l, int h)
    {
        //Your code here
        int[] ans = new int[1];
        findCount(root, l, h, ans);
        return ans[0];
    }
    
    void findCount(TreeNode node, int l, int h, int[] ans) {
        
        if (node == null) return;
        
        if (node.val >= l && node.val <= h) {
            ans[0]++;
        }
        
        findCount(node.left, l, h, ans);
        findCount(node.right, l, h, ans);
    }
}
