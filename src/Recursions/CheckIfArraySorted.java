package Recursions;
public class CheckIfArraySorted {
    public static void main(String[] args) {
        int[] arr = {-1,2,3,4,5,6};
        System.out.println(checkSorted(arr, 0, 1));
    }

    /*
    the main moto of this function is to check if the array is strictly sorted
    {1,2,3,4,5,6} -> true
    {1,2,3,4,,5,5} -> false since this is not strictly increasing.
    */
    static boolean checkSorted(int[] arr, int currentInd, int upIndex) {

        // if all the elements are sorted till the last element then it will retuen true.
        // base conditon
        if (currentInd == arr.length - 1) {
            return true;
        }

        if (arr[currentInd] < arr[upIndex]) {
            return checkSorted(arr, currentInd + 1, upIndex + 1);
        } else {
            return false;
        }

    }
}
