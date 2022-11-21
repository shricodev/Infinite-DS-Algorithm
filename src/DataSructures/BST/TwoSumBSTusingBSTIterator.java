package DataSructures.BST;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isRev) {
        reverse = isRev;
        pushAll(root);
    }

    public void pushAll(TreeNode root) {
        while (root != null) {
            st.add(root);
            if (reverse == true) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    public int next() {
        TreeNode node = st.pop();
        if (reverse)
            pushAll(node.left);
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext(TreeNode node) {
        if (!st.isEmpty()) {
            return true;
        }
        return false;
    }
}

public class TwoSumBSTusingBSTIterator {

    // this is not the very intuitive one.
    // time complexity; O(n)
    // space complexity; o(2H)
    public boolean findTarget(TreeNode root, int k) {

        // normal BST iterator.
        BSTIterator next = new BSTIterator(root, false);
        // BST iterator but in reverse fashion: right, root, left.
        BSTIterator before = new BSTIterator(root, true);

        int i = next.next();
        int j = before.next();

        while (i < j) {
            if (i + j == k)
                return true;

            if (i + j > k) {
                j = before.next();
            } else {
                i = next.next();
            }
        }
        return false;
    }
}
