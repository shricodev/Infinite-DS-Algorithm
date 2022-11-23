package DataSructures.Trees;

public class SortedArrayToBST {

    // * TIP: when we get the sorted array always think of the Binary search first.
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return constructTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructTree(int[] nums, int start, int end) {

        if (start > end) return null;

        int mid = start + (end - start) / 2;
        // we create node from the middle of the nums.
        TreeNode node = new TreeNode(nums[mid]);

        node.left = constructTree(nums, start, mid - 1);
        node.right = constructTree(nums, mid + 1, end);
        
        return node;
    }
}
