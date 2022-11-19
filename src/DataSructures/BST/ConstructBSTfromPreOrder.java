package DataSructures.BST;

// one approach can be sorting the preorder which gives the inorder of the bST
// and construct the BT from the preorder and inorder which will be BST.
public class ConstructBSTfromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = findBST(preorder, Integer.MAX_VALUE, new int[] { 0 });
        return root;
    }

    // we don't need the left boundary since the node.val acts as the left boundary
    public TreeNode findBST(int[] preorder, int bound, int[] pointer) {

        if (pointer[0] == preorder.length || preorder[pointer[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pointer[0]++]);

        root.left = findBST(preorder, root.val, pointer);
        // we need to use the same right boundary when we return.
        root.right = findBST(preorder, bound, pointer);

        return root;
    }
}
