package Patterns.Iterations.Numbers;

public class pattern4 {
    public static void main(String[] args) {
        draw(5);
    }

    /*
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
     */
    static void draw(int n) {

        // outer loop for row.
        for (int row = 1; row <= n; row++) {
            // for every column in each row.
            for (int col = 1; col <= row; col++) {
                // since we want to print no in each col of each row.
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
