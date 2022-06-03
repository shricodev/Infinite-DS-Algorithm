package Recursions;
public class CheckElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 56, 65, 7, 98, 0};
        System.out.println(findElement(arr, 100, 0));
    }

    static boolean findElement(int[] arr, int target, int index) {

        // base condition.
        if (index >= arr.length) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return findElement(arr, target,  index + 1);
    }
}
