package BackTracking;

import java.util.Arrays;

public class NQueensNotOptimised {
    public static void main(String[] args) {
        int n = 5;
        char[][] mat = new char[n][n];

        // adding the "." to the matrix.
        for(char[] row: mat) {
            Arrays.fill(row, '.');
        }

        System.out.println("The count is: " + nQueens(mat, 0));
    }

    // time complexity: O(N * T(N-1)) + O(N^2 since the bracket complexity is going to run for all n^2 elem)) = O(n^3) + N! -> O(N!)
    // space complexity: O(N^2)
    static int nQueens(char[][] mat, int col) {

        if (col == mat.length) {
            printAns(mat);
            return 1;
        }

        int count = 0;

        for (int row = 0; row < mat.length; row++) {
            
            // if it is safe to add a queen in given row and col.
            if (isSafe(row, col, mat)) {

                // add the queen in the current index.
                // one work done now call the fxn for the rest of the work
                mat[row][col] = 'Q';

                // recursive leap of faith
                count += nQueens(mat, col + 1);

                // backtrack and remove the queen from the current box
                mat[row][col] = '.';
            }
        }

        return count;
    }

    private static void printAns(char[][] mat) {
        for (char[] cs : mat) {
            System.out.print(Arrays.toString(cs).replaceAll(",", ""));
            System.out.println();
        }
        System.out.println();
    }

    // NOTE: we are only checking for the left portion since we are adding the queen from left to right.
    private static boolean isSafe(int row, int col, char[][] mat) {

        int x = row;
        int y = col;

        // check for the same row in the matrix.
        while(y >= 0) {
            if (mat[x][y] == 'Q') return false;
            y--;
        }

        // NOTE: there is no need to check for the column since we are only placing one Q in one column and moving to the next col.

        x = row;
        y = col;

        // upper left diagonal
        while (x >= 0 && y >= 0) {
            if (mat[x][y] == 'Q') return false;
            x--;
            y--;
        }

        x = row;
        y = col;

        // lower left diagonal
        while (x < mat.length && y >= 0) {
            if (mat[x][y] == 'Q') return false;
            x++;
            y--;
        }

        return true;
    }
}
