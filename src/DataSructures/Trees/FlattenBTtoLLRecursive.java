package DataSructures.Trees;

public class FlattenBTtoLLRecursive {

    public static void main(String[] args) {
        // System.out.println(flatten(root, null));
    }
    
    // for future reference: https://youtu.be/sWf7k1x9XR4?list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&t=247
    // we cannot create a new linked list, we should modify the tree to act as a linked list
    public static void flatten(TreeNode node, TreeNode prev) {
        if (node == null) {
            return;
        }
        flatten(node.right, prev);
        flatten(node.left, prev);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
