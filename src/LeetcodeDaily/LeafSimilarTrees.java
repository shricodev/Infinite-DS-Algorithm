package LeetcodeDaily;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        findLeaves(root1, leaves1);
        findLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void findLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) leaves.add(node.val);
        
        findLeaves(node.left, leaves);
        findLeaves(node.right, leaves);
    }
}
