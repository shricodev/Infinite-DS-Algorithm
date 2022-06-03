package Data_Structures.arrays;

public class CheckElemInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 56, 65, 7, 98, 0};
        System.out.println(findElem(arr, 100, 0));
    }

    static boolean findElem(int[] arr, int target, int index) {

        // base condition.
        if (index >= arr.length) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return findElem(arr, target,  index + 1);
    }
}
