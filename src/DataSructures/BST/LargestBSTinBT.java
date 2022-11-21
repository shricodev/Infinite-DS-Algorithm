package DataSructures.BST;


class NodeData {
    int minValue;
    int maxValue;
    int maxSize;
    public NodeData(int minValue, int maxValue, int maxSize) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSize = maxSize;
    }
}


public class LargestBSTinBT {
    
    // * NOTE: 
    // the brute soln is taking each node and passing it to the valid BST function.
    // and if true then pass the node to count no of node below fxn.


    // optimal
    // TC: O(n)
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).maxSize;
    }

    // since we are going from bottom to top so we need a algorithm to compute left and right then itself.
    // so using the post order traversal.
    public NodeData helper(TreeNode root) {
        if (root == null) {
            // for null node we return a dummy node with max as min and min as max so we can compare.
            return new NodeData(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeData left = helper(root.left);
        NodeData right = helper(root.right);

        // then it is the bST.
        if (left.maxValue < root.val && root.val < right.minValue) {
            return new NodeData(Math.min(left.minValue, root.val), Math.max(right.maxValue, root.val), 1 + left.maxSize + right.maxSize);
        }

        // if not return the very high val for min and very low val for max so parent can't be the BST.
        return new NodeData(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));

    }
}
