package DataSructures.Trees;

public class CountNodesCompleteBT {
    
    // * NOTE: we are said to design an algorithm which uses time lesser than O(N)
    // if it hadn't said that we could use any traversal method to count.
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHt = findLeftHt(root.left);
        int rightHt = findRightHt(root.right);

        if (leftHt == rightHt) {
            return  (2 << (leftHt) - 1);
        }
        // + 1 for the current node height.
        return 1 + countNodes(root.left) + countNodes(root.right);
        
    }

    private int findLeftHt(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int findRightHt(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
    
}
