package BackTracking;

import java.util.Arrays;

public class SudokuSolve {
    public static void main(String[] args) {

        char[][] board = { 
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'} 
                };

        sudoku(board);
    }

    // TC: O(9^empty cell)
    // SC: O(1)
    static void sudoku(char[][] sudokuBrd) {
        solve(sudokuBrd);
        // System.out.println(Arrays.deepToString(sudokuBrd));
        // OR
        for (char[] cs : sudokuBrd) {
            System.out.println(Arrays.toString(cs));
        }
    }

    private static boolean solve(char[][] sudokuBrd) {

        // iterating over the matrix of size 9x9, since the sudoku is going to be of size 9x9
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                // if the element is empty then we take action.
                if (sudokuBrd[row][col] == '.') {

                    // checking for all possible values from 1 to 9.
                    for (char value = '1'; value <= '9'; value++) {

                        // if it's safe to place the value in the index of the board.
                        if (isSafe(row, col, sudokuBrd, value)) {

                            sudokuBrd[row][col] = value;

                            // at last since all the values of the sudoku will be placed so for the last recursion 
                            // call will have no '.' so the method returns true;
                            // if the recursion returns true then just do not backtrack and remove the element
                            if (solve(sudokuBrd)) return true;

                            // backtrack to remove the added value;
                            sudokuBrd[row][col] = '.';
                        }
                    }
                    // if we cannot place a element in the index then just return a false;
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int row, int col, char[][] sudokuBrd, char value) {

        for (int i = 0; i < 9; i++) {

            // checking the row
            if (sudokuBrd[row][i] == value)
                return false;

            // checking the column
            if (sudokuBrd[i][col] == value)
                return false;

            // checking the 3x3 box
            if (sudokuBrd[3 * (row/3) + i/3][3 * (col / 3) + i % 3] == value) return false;

        }

        return true;
    }
}
