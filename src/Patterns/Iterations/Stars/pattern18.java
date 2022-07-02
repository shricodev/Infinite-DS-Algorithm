package Patterns.Iterations.Stars;

public class pattern18 {
    public static void main(String[] args) {
        draw(5);
    }
    /*
    **********
    ****  ****
    ***    ***
    **      **
    *        *
    *        *
    **      **
    ***    ***
    ****  ****
    **********
     */
    static void draw(int n) {
        // upper row
        for (int row = 0; row < n; row++) {
            
            // upper left 
            for (int col = 1; col <= n - row; col++) {
                System.out.print("*");
            }

            // upper middle spaces
            for (int sp = 1; sp <= 2 * row; sp++) {
                System.out.print(" ");
            }

            // upper right inverted triangle.
            for (int col = 1; col <= n - row; col++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // lower row
        // logic is just copy paste the code but change the row from n - 1 to 0
        for (int row = n - 1; row >= 0; row--) {
            
            // lower right 
            for (int col = 1; col <= n - row; col++) {
                System.out.print("*");
            }

            // lower mid spaces
            for (int sp = 1; sp <= 2 * row; sp++) {
                System.out.print(" ");
            }

            // lower right 
            for (int col = 1; col <= n - row; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
