package DataSructures.Arrays;

import java.util.ArrayList;

public class FindAllIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 10};
        findAllInd(arr, 10, 0);
        System.out.println(list);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllInd(int[] arr, int target, int index) {

        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        findAllInd(arr, target, index + 1);
    }
}
