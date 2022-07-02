package Searching.BinarySearching.TwoDArray;

import java.util.Arrays;

public class SearchNRowColMatrix {

    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30, 40},
            {15, 25, 31, 42},
            {22, 27, 33, 43},
            {24, 28, 35, 45}
        };

        System.out.println(Arrays.toString(search(arr, 45)));
    }

    // this works for n x n array.
    static int[] search(int[][] arr, int target) {

        
        int row = 0;
        // since the arr.length gives the length of arr since it is a n x n array length - 1 gives the col. 
        int col = arr.length - 1;

        while (row < arr.length && col >= 0) {

            if (arr[row][col] == target) {
                return new int[]{row, col};
            }

            if (arr[row][col] < target) {
                row++;

            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
    
}