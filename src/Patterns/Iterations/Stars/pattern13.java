package Patterns.Iterations.Stars;

public class pattern13 {
    public static void main(String[] args) {
        draw(5);
    }
    /*
        *
       * *
      *   *
     *     *
    *********
     */
    static void draw(int n) {

        for (int row = 0; row < n; row++) {
            
            for (int sp = row; sp <= n; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= 2 * row + 1; col++) {

                if  (col == 1 || col == 2 * row + 1 || row == n - 1) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
