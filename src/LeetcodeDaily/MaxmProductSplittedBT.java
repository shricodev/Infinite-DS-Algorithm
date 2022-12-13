package LeetcodeDaily;



class Solution {

    long totalSum = 0;
    long maxP = 0;
    int MOD = (int) 1e9 + 7;

    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        totalSum = findTotalSum(root);
        findMaxP(root);
        return (int) maxP % MOD;

    }
    private int findMaxP(TreeNode root) {
        if (root == null) return 0;
        
        int sumLeft = findMaxP(root.left);
        int sumRight = findMaxP(root.right);

        long subtreeSum = root.val + sumLeft + sumRight;
        long subtreeSumRemain = totalSum - subtreeSum;

        maxP = Math.max(maxP, subtreeSum * subtreeSumRemain);

        return (int) subtreeSum;
    }

    private int findTotalSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = findTotalSum(root.left);
        int rightSum = findTotalSum(root.right);

        int sum = root.val + leftSum + rightSum;
        return sum;
    }
}
