package LeetcodeDaily;

class Solution {
    int ans = 0;

    public int maxAncestorDiff(TreeNode node) {
        findMaxDiff(node);
        return ans;
    }

    public int[] findMaxDiff(TreeNode node) {
        // min, maxi.
        if (node == null)
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };

        if (isLeaf(node))
            return new int[] { node.val, node.val };

        int[] left = findMaxDiff(node.left);
        int[] right = findMaxDiff(node.right);
        
        // finding the min of left and right subtree.
        int min = Math.min(left[0], right[0]);
        // finding the max of left and right subtree.
        int maxi = Math.max(left[1], right[1]);

        ans = Math.max(ans, Math.max(Math.abs(min - node.val), Math.abs(maxi - node.val)));

        // after calculating the ans the min or the maxi can be the node.val itself so
        // check for the condition as well.
        min = Math.min(min, node.val);
        maxi = Math.max(maxi, node.val);

        return new int[] { min, maxi };
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}