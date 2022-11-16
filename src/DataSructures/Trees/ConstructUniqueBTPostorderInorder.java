package DataSructures.Trees;

import java.util.HashMap;

public class ConstructUniqueBTPostorderInorder {
    public static TreeNode buildTree(int inorder[], int postorder[], int n) {
        // code here

        if (inorder == null || postorder == null || postorder.length != inorder.length)
            return null;
        HashMap<Integer, Integer> mapInorder = new HashMap<>();
        // creating a hashmap as node, ind so we do not need to traverse the inorder
        // array all
        for (int i = 0; i < n; i++) {
            mapInorder.put(inorder[i], i);
        }
        // after building the tree we need to return the root.
        TreeNode root = findNode(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, mapInorder);
        return root;
    }

    private static TreeNode findNode(int[] postorder, int postStart, int postEnd, int[] inorder, Integer inStart,
            int inEnd, HashMap<Integer, Integer> mapInorder) {
        // if any of these happens, we are at the end of the tree.
        if (postStart > postEnd || inStart > inEnd)
            return null;

        // creating the root from the end: Left, Right, Root
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = mapInorder.get(root.val);

        // no in the left of inRoot.
        int numsLeft = inRoot - inStart;

        root.left = findNode(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, mapInorder);
        root.right = findNode(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, mapInorder);

        return root;
    }
}
