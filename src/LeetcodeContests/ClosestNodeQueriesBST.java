package LeetcodeContests;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ClosestNodeQueriesBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);
        System.out.println(closestNodes(root, queries));

    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            ans.add(new ArrayList<>());
        }
        int size = queries.size();
        for (int i = 0; i < size; i++) {
            int elem = queries.get(i);
            int floor = floorSearch(inorder, 0, inorder.size() - 1, elem);
            int ceiling = ceilingNumber(inorder, elem, 0, inorder.size() - 1);
            ans.get(i).add(floor);
            ans.get(i).add(ceiling);
        }
        return ans;
    }

    public static void findInorder(TreeNode node, List<Integer> inorder) {
        if (node == null)
            return;

        findInorder(node.left, inorder);
        inorder.add(node.val);
        findInorder(node.right, inorder);

    }

    static int ceilingNumber(List<Integer> arr, int target, int start, int end) {

        if (arr.get(arr.size() - 1) < target) {
            return -1;
        }

        if (start > end) {
            return arr.get(start);
        }

        int middle = start + (end - start) / 2;

        if (arr.get(middle) == target) {
            return arr.get(middle);
        }

        if (target < arr.get(middle)) {
            return ceilingNumber(arr, target, start, middle - 1);
        }

        return ceilingNumber(arr, target, middle + 1, end);
    }

    static int floorSearch(List<Integer> arr, int low, int high, int x) {
        if (low > high)
            return -1;

        if (x >= arr.get(high))
            return arr.get(high);

        int mid = (low + high) / 2;

        if (arr.get(mid) == x)
            return arr.get(mid);

        if (mid > 0 && arr.get(mid - 1) <= x && x < arr.get(mid))
            return arr.get(mid - 1);

        if (x < arr.get(mid))
            return floorSearch(arr, low, mid - 1, x);

        return floorSearch(arr, mid + 1, high, x);
    }

}
