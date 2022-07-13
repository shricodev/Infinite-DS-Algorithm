package Sorting.Cyclic;

import java.util.ArrayList;
import java.util.List;

public class NumbersDisappearedInArr_LC {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,3,2,1};
        System.out.println(findMissing(nums));
    }


    static List<Integer> findMissing(int[] nums) {
        int ithInd = 0;
        
        while (ithInd < nums.length) {

            // for 1 based indexing - 1.
            int correctIndx4IthElem = nums[ithInd] - 1;

            // if the nums[ithInd] is equal to the size of the array then there is no index 
            // so just ignore.
            if(correctIndx4IthElem < nums.length && nums[ithInd] != nums[correctIndx4IthElem]) {
                swap(nums, ithInd, correctIndx4IthElem);

            } else {
                ithInd++;
            }
        }

        List<Integer> ansHolder = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ansHolder.add(i + 1);
            }
        }
        
        return ansHolder;
    }

    static void swap(int[] arr, int start, int end) {

        // this does all the swap of the elem in the array.
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

    }
}
