package DataSructures.Trees;

class Node {
    int data;
    Node  left,  right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}

public class ChildrenSumPropertyON {
    
    public static void changeTree(Node root) {
        reorderTree(root);
    }
    
    // Time complexity; O(n) 
    private static void reorderTree(Node root) {
        if (root == null) return;
        int child = 0;

        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;

        if (child >= root.data) root.data = child;
        else {
            // if the child  is smaller than the root.
            if (root.left != null) root.left.data = root.data;
            else if (root.right != null) root.right.data = root.data;
        }
        reorderTree(root.left);
        reorderTree(root.right);
        // backtrack and reassign the two childs value to the node iff root is not the child node.
        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        // means it it not a leaf node.
        if (root.left != null || root.right != null) root.data = total;
    }
}
