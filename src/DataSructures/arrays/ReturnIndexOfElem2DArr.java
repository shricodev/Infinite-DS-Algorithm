package DataSructures.Arrays;

import java.util.Arrays;

public class ReturnIndexOfElem2DArr {
    public static void main(String[] args) {
        int[][] arr = {
            {260, 2, 3, 4},
            {5, 8, 9, 0, 69},
            {1000, 200000, 1},
            {23, 64}
        };
        int[] ansReturned = findInd(arr, 1000);

        System.out.println(Arrays.toString(ansReturned));   
    }

    static int[] findInd(int[][] arr, int target) {

        if (arr.length == 0) {
            return new int[] {-1 , -1};
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    // return an integer array with row, col as the value.
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
