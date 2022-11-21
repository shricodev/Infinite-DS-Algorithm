package DataSructures.BST;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {
    
    // time complexity: o(n) + O(n) -> Brute solution
    // space complexity: O(n)
    public static boolean findTargetBrute(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder);
        int i = 0;
        int j = inorder.size() - 1;

        // since the array is sorted, we can use this property.
        while (i < j) {

            if (inorder.get(i) + inorder.get(j) == k) return true;

            if (k < inorder.get(i) + inorder.get(j)) {
                j -= 1;
            }
            else i += 1;
        }
        return false;
    }

    private static void findInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        findInorder(root.left, inorder);
        inorder.add(root.val);
        findInorder(root.right, inorder);
    }
}
