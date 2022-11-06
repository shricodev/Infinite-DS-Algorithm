package DataSructures.Trees;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    };

    TreeNode() {}

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
 * the brute force solution would be this: but it has time complexity of O(n^2)
 * int height(TreeNode* root){
 *      if(root==NULL) return 0;
 *  int x = 1 + height(root.left);
 *  int y = 1 + height(root.right);
 * 
 *  return Math.max(x,y);
 * }
 * 
 * int maxi=0;
 * int diameterOfBT(TreeNode* root) {
 *  if(root==NULL) return 0;
 * 
 *  int leftHt = height(root.left);
 *  int rightHt = height(root.right);
 * 
 *  maxi = Math.max(maxi, leftHt+rightHt);
 *  int left = diameterOfBT(root.left);
 *  int right = diameterOfBT(root.right);
 * 
 *  return maxi;
 * }
 */

public class DiameterOfBT {

    int diameter(TreeNode root) {

        int[] diameter = new int[1];
        maxDepthRec(root, diameter);
        return diameter[0];

    }

    int maxDepthRec(TreeNode node, int[] diameter) {
        if (node == null)
            return 0;
        int leftHt = maxDepthRec(node.left, diameter);
        int rightHt = maxDepthRec(node.right, diameter);
        // the maxi is the sum of leftht + rightHt for the node. +1 is differenciable in
        // leetcode and gfg qn.
        diameter[0] = Math.max(diameter[0], leftHt + rightHt + 1);
        return 1 + Math.max(leftHt, rightHt);
    }
}
