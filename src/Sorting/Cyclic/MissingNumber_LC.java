package Sorting.Cyclic;


public class MissingNumber_LC {
    public static void main(String[] args) {
        int[] arr = {0, 3, 5, 1, 4};
        System.out.println(findMissing(arr));
    }


    static int findMissing(int[] nums) {
        int ithInd = 0;

        while (ithInd < nums.length) {

            int correctIndx4IthElem = nums[ithInd];

            // if the nums[ithInd] is equal or greater than the size of the array then there is no index 
            // so just ignore.
            if(correctIndx4IthElem < nums.length && nums[ithInd] != nums[correctIndx4IthElem]) {
                swap(nums, ithInd, correctIndx4IthElem);

            } else {
                ithInd++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        // if there is no missing elem till the n - 1 index then return n
        return nums.length;
    }

    static void swap(int[] arr, int start, int end) {

        // this does all the swap of the elem in the array.
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

    }
}
