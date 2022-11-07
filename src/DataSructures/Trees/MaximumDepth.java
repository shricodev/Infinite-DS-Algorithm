package DataSructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {
    // time complexity: O(n)
    // space complexity: O(n)
    public int maxDepthRec(Node node) {
        if (node == null) return 0;
        int leftHt = 1 + maxDepthRec(node.left);
        int rightHt = 1 + maxDepthRec(node.right);
        return Math.max(leftHt, rightHt);
    }

    // since this is level wise so we can just do + 1 for each level.
    public int maxDepthIteration(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node temp = q.remove();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return maxDepth;
    }
}
