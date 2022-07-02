package Patterns.Iterations.Stars;

public class pattern25 {
    public static void main(String[] args) {
        draw(5);
    }

    /*
        *****
       *   *
      *   *
     *   *
    *****
     */
    static void draw(int n) {

        for (int row = 1; row <= n; row++) {
            
            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= n; col++) {
                if (row == 1 || row == n || col == 1 || col == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
