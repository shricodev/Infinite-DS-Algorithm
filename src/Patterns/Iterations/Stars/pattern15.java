package Patterns.Iterations.Stars;

public class pattern15 {
    public static void main(String[] args) {
        draw(4);
    }
    /*
         *
        * *
       *   *
      *     *
     *       *
      *     *
       *   *
        * *
         *
     */
    static void draw(int n) {

        // upper n - 1 row
        for (int row = 0; row < n - 1; row++) {
            
            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= 2 * row + 1; col++) {

                if (col == 1 || col == 2 * row + 1) {
                    System.out.print("*");

                } else {

                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        // lower n row
        // for lower half we just need to copy the same old code for the upper half and 
        // reverse the row condition since all the logic inside the code all depends on the row 
        // so no need of any change in the inside code

        for (int row = n - 1; row >= 0; row--) {
            
            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= 2 * row + 1; col++) {

                if (col == 1 || col == 2 * row + 1) {
                    System.out.print("*");

                } else {

                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
