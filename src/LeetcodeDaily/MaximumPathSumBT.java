package LeetcodeDaily;

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


public class MaximumPathSumBT {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        // filling the index with negative since the max sum can be negative, so 0 wont work here.
        maxi[0] = Integer.MIN_VALUE;
        helper(root, maxi);
        return maxi[0];
    }

    int helper(TreeNode node, int[] maxi) {
        if(node == null) return 0;
        
        // we will not do something like node.data + Math.max(0, helper(node.left,  maxi))
        // for left sum and the right sum and maxi as Math.max(maxi[0], leftSum + rightSum)
        // since it adds node val twice, it is good only when comparing. 
        // comparing with 0 since we need the maxm path sum, so we will neglect the path with negative val.
        int leftSum = Math.max(0, helper(node.left, maxi));
        int rightSum = Math.max(0, helper(node.right, maxi));
        maxi[0] = Math.max(maxi[0], leftSum + rightSum + node.val);
        // we take the max of the left or right sum as we need the max sum of these paths.
        return node.val + Math.max(leftSum , rightSum);
    }
    
    // more intuitive code for the soln from interview ds algo.
    int helperIntuitive(TreeNode node) {
        if (node == null) return 0;

        int leftSum = helperIntuitive(node.left);
        int rightSum = helperIntuitive(node.right);
        
        // 3 conditions
        int onePathGood = node.val + Math.max(leftSum, rightSum);
        int noPathGood = node.val;
        int foundAnsDown = node.val + leftSum + rightSum;
        
        maxSum = Math.max(noPathGood, Math.max(onePathGood, foundAnsDown));

        // since we are already satisfied with the ans of the found Ans down so not sending it to the upper node.
        return Math.max(noPathGood, onePathGood);
    }
}
