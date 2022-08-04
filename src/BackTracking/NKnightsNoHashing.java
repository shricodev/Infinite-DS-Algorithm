package BackTracking;

import java.util.Arrays;

public class NKnightsNoHashing {
    public static void main(String[] args) {
        int n = 3;
        char[][] mat = new char[n][n];

        // adding the "." to the matrix.
        for (char[] row : mat) {
        Arrays.fill(row, '.');
        }
        System.out.println("The count is: " + nKnights(mat, 0));
    }

    // RULES
    // - each col should have a single knight
    // - no two knights should attack each other
    static int nKnights(char[][] mat, int col) {

        if (col == mat.length) {
            printAns(mat);
            return 1;
        }

        int count = 0;

        for (int row = 0; row < mat.length; row++) {

            // if it is safe to add a queen in given row and col.
            if (isSafe(row, col, mat)) {

                // add the knight in the current index.
                // one work done now call the fxn for the rest of the work
                mat[row][col] = 'K';

                // we just dont need to move to next col for knight as for queen, we can check
                // for knights place in the col more
                // recursive leap of faith
                count += nKnights(mat, col + 1);

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

    // NOTE: we are only checking for the left portion since we are adding the queen
    // from left to right.
    private static boolean isSafe(int row, int col, char[][] mat) {

        int x = row;
        int y = col;

        // left up
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (mat[x - 1][y - 2] == 'K')
                return false;
        }

        x = row;
        y = col;

        // right up
        if (x - 1 >= 0 && y + 2 < mat.length) {
            if (mat[x - 1][y + 2] == 'K')
                return false;
        }

        x = row;
        y = col;

        // left down
        if (x + 1 < mat.length && y - 2 >= 0) {
            if (mat[x + 1][y - 2] == 'K')
                return false;
        }

        x = row;
        y = col;

        // right down
        if (x + 1 < mat.length && y + 2 < mat.length) {
            if (mat[x + 1][y + 2] == 'K')
                return false;
        }

        x = row;
        y = col;

        // up left
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (mat[x - 2][y - 1] == 'K')
                return false;
        }

        x = row;
        y = col;

        // up right
        if (x - 2 >= 0 && y + 1 < mat.length) {
            if (mat[x - 2][y + 1] == 'K')
                return false;
        }

        x = row;
        y = col;

        // down left
        if (x + 2 < mat.length && y - 1 >= 0) {
            if (mat[x + 2][y - 1] == 'K')
                return false;
        }

        x = row;
        y = col;

        // down right
        if (x + 2 < mat.length && y + 1 < mat.length) {
            if (mat[x + 2][y + 1] == 'K')
                return false;
        }

        return true;
    }
}
