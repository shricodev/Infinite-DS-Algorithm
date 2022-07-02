package Patterns.Iterations.Stars;

public class pattern12 {
    public static void main(String[] args) {
        draw(10);
    }
    /*
     * * * * *
      * * * *
       * * *
        * *
         *
         *
        * *
       * * *
      * * * *
     * * * * *
     */
    static void draw(int n) {
        // upper half
        for (int row = 1; row <= n; row++) {

            for (int sp = 1; sp <= row; sp++) {
                System.out.print(" ");
            }

            for (int col = row; col <= n; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // lower half
        for (int row = n; row >= 1; row--) {

            for (int sp = 1; sp <= row; sp++) {
                System.out.print(" ");
            }

            for (int col = row; col <= n; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
        


    }
}
