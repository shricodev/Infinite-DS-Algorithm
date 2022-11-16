package DataSructures.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class MinmTimeToBurnBT {

    public static int minTime(Node root, int target) {

        HashMap<Node, Node> parents = new HashMap<>();
        Node targetNode = markparents(root, parents, target);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        int minTime = 0;
        q.add(targetNode);
        visited.put(targetNode, true);
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    q.add(node.left);
                    visited.put(node.left, true);
                    flag++;
                }
                if (node.right != null && visited.get(node.right) == null) {
                    q.add(node.right);
                    visited.put(node.right, true);
                    flag++;
                }
                if (parents.get(node) != null && visited.get(parents.get(node)) == null) {
                    q.add(parents.get(node));
                    visited.put(parents.get(node), true);
                    flag++;
                }
            }

            if (flag != 0) {
                minTime++;
            }
        }
        return minTime;

    }

    private static Node markparents(Node root, HashMap<Node, Node> parents, int target) {
        Queue<Node> q = new LinkedList<>();
        Node targetNode = new Node(-1);
        if (root.data == target)
            targetNode = root;
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.data == target)
                targetNode = node;
            if (node.left != null) {
                q.add(node.left);
                parents.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                parents.put(node.right, node);
            }
        }
        return targetNode;
    }
}
