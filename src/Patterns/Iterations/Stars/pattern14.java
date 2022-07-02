package Patterns.Iterations.Stars;

public class pattern14 {
    public static void main(String[] args) {
        draw(6);
    }

    /*
    *********
     *     *
      *   *
       * *
        *
     */
    static void draw(int n) {

        // row
        for (int row = 1; row <= n; row++) {
            
            // space
            for (int sp = 1; sp < row; sp++) {
                System.out.print(" ");
            }

            // stars
            for (int col = 1; col <= 2 * (n - row) + 1; col++) {

                if (row == 1 || row == n || col == 1 || col == 2 * (n - row) + 1) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
