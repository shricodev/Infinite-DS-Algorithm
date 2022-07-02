package Patterns.Iterations.Numbers;

public class pattern17 {
    public static void main(String[] args) {
        draw(5);
    }

    /*
       1
      212
     32123
    4321234
     32123
      212
       1
     */
    static void draw(int n) {
        
        // upper n row
        for (int row = 1; row <= n; row++) {
            
            for (int sp = 1; sp <= n - row; sp++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }

            for (int col = 2; col <= row; col++) {
                System.out.print(col);
            }

            System.out.println();
        }

        // lower n - 1 row
        for (int row = n - 1; row >= 1; row--) {
            
            for (int sp = 1; sp <= n - row; sp++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }

            for (int col = 2; col <= row; col++) {
                System.out.print(col);
            }

            System.out.println();
        }
    }
}
