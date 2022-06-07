package Searching.linearSearching;

public class FindMin2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {260, 2, 3, 4},
            {5, 8, 9, 0},
            {1000, 200000, 1},
            {23, 64}
        };
        System.out.println(findMin(arr));
    }

    static int findMin(int[][] arr) {
        int min = arr[0][0];

        for (int row = 0; row < arr.length; row++) {
            // arr[row].length will give the length of the row we are iterating in.
            // we can search in not symmetrical array  as well with this method.
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] < min) {
                    min = arr[row][col];
                }
            }
        }
        return min;
    }
}
