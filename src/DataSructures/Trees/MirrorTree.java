package DataSructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
    void mirror(Node node) {
        node = mirrorTree(node);
    }

    // the recursive method to solve the problem
    Node mirrorTree(Node node) {
        // Your code here
        if (node == null)
            return null;

        Node left = mirrorTree(node.left);
        Node right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;

    }

    Node mirrorTreeIterative(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            swap(node.left, node.right);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return root;
    }

    private void swap(Node left, Node right) {
        Node temp = left;
        left = right;
        right = temp;
    }
}
