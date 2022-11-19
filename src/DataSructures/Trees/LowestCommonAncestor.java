package DataSructures.Trees;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LowestCommonAncestor {

    Node lcaOptimal(Node root, Node n1, Node n2) {

        if (root == null) return null;
        if(root == n1 || root == n2) return root;
        
        Node left = lcaOptimal(root.left, n1, n2);
        Node right = lcaOptimal(root.right, n1, n2);

        if (left == null) return right;
        if (right == null) return left;
        // both are not null, meaning we found our ans.
        else return root;
    }


    // fails leetcode test case: 29/31
    Node lca(Node root, Node n1, Node n2) {
        // Your code here

        if (n1 == null && n2 == null) {
            return new Node(-1);
        }

        ArrayList<Integer> n1Path = new ArrayList<>();
        ArrayList<Integer> n2Path = new ArrayList<>();

        helper(root, n1, n1Path);
        helper(root, n2, n2Path);

        int lastMatched = -1;

        for (int i = 0; i < Math.min(n1Path.size(), n2Path.size()); i++) {
            if (n1Path.get(i) == n2Path.get(i))
                lastMatched = n1Path.get(i);
        }

        Node node = new Node(lastMatched);
        return node;
    }

    private boolean helper(Node node, Node b, ArrayList<Integer> ans) {

        if (node == null)
            return false;

        ans.add(node.data);
        if (node.data == b.data) {
            return true;
        }
        if (helper(node.left, b, ans) || helper(node.right, b, ans) == true)
            return true;
        // backtrack
        ans.remove(ans.size() - 1);
        return false;
    }
}
