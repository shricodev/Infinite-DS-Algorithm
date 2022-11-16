package DataSructures.Trees;

import java.util.HashMap;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    };

    TreeNode() {
        ;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructUniqueBTPreorderInorder {

    public static TreeNode buildTree(int inorder[], int preorder[], int n) {
        // code here
        HashMap<Integer, Integer> mapInorder = new HashMap<>();
        // creating a hashmap as node, ind so we do not need to traverse the inorder array all
        for (int i = 0; i < n; i++) {
            mapInorder.put(inorder[i], i);
        }
        // after building the tree we need to return the root.
        TreeNode root = findNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, mapInorder);
        return root;
    }

    private static TreeNode findNode(int[] preorder, int preStart, int preEnd, int[] inorder, Integer inStart, int inEnd, HashMap<Integer, Integer> mapInorder) {
        // if any of these happens, we are at the end of the tree.
        if (preStart > preEnd || inStart > inEnd) return null;

        // creating the root from the preStart: Root, Left, Right
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = mapInorder.get(root.val);

        // no in the left of inRoot.
        int numsLeft = inRoot - inStart;

        root.left = findNode(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, mapInorder);
        root.right = findNode(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, mapInorder);
        
        return root; 
    }

}
