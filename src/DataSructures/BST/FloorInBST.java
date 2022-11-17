package DataSructures.BST;


public class FloorInBST {
    
    // the node val just greater than or equals to the key.
    int findCeil(TreeNode root, int key) {
            if (root == null) return -1;
    
            int ceil = -1;
            while (root != null) {
                // if val is equals to key then no need to iterate all over.
                if (root.val == key) {
                    ceil = root.val;
                    return ceil;
                }
                
                // if key is lesser than the root val search in the left.
                if (key < root.val) {
                    root = root.left;
                }
                else {
                    // search in the right.
                    ceil = root.val;
                    root = root.right;
                }
            }
            return ceil;
        }
    }
