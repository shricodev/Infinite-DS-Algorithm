package DataSructures.Trees;

import java.util.ArrayList;

class Node  
{ 
    int data; 
    Node left, right; 

    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class Solution
{
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }


    void findLeftBoundary(Node node, ArrayList<Integer> ans) {
        Node currNode = node.left;
        while (currNode != null) {
            if (!isLeaf(currNode)) ans.add(currNode.data);
            if (currNode.left != null) currNode = currNode.left;
            else currNode = currNode.right;
        }
    }

    // pre order traversal.
    // any other traversal works absolutely fine.
    private void findLeafNode(Node node, ArrayList<Integer> ans) {
        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        
        if (node.left != null) findLeafNode(node.left, ans);
        if (node.right != null) findLeafNode(node.right, ans);
    }

    private void findRightBoundaryRev(Node node, ArrayList<Integer> ans) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node currNode = node.right;
        while(currNode != null) {
            if (!isLeaf(currNode)) temp.add(currNode.data);
            if (currNode.right != null) currNode = currNode.right;
            else currNode = currNode.left;
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(node)) ans.add(node.data);
        // for finding the left boundary.
        findLeftBoundary(node, ans);
        // to find the leaf node using the Inorder traversal.
        findLeafNode(node, ans);
        // to find the right boundary but in reverse, not addign
        findRightBoundaryRev(node, ans);
        return ans;
    }
}
