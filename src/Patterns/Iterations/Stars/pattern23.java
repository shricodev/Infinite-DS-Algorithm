package Patterns.Iterations.Stars;

public class pattern23 {
    public static void main(String[] args) {
        draw(4);
    }

    /*
           *      *
         *   *  *   *
       *      *      *
     */
    static void draw(int n) {

        for (int row = 1; row <= n; row++) {
            
            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= 2 * row - 1; col++) {

                if (row == 1 || col == 1 || col == 2 * row - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            for (int col = 1; col <= 2 * (n - row); col++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= 2 * row - 1; col++) {

                if (row == 1 || col == 1 || col == 2 * row - 1) {

                    if (row == n && col == 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }

                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
