package Patterns.Iterations.Numbers;

public class pattern35 {
    public static void main(String[] args) {
        draw(4);
    }

    static void draw(int n) {

        // row
        for (int row = 1; row <= n; row++) {
            
            // left triangle
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }

            // middle spaces
            for (int sp = 1; sp <= 2 * (n - row); sp++) {
                System.out.print("  ");
            }

            // right triangle
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }
}
