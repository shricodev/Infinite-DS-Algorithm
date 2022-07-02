package Patterns.Iterations.Stars;

public class NepalFlag {
    public static void main(String[] args) {
        draw(5);
    }
    
    static void draw(int n) {

        // upper n row.
        for (int row = 1; row <= n; row++) {
            
            for (int col = 1; col <= 2 * row - 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // lower n row
        for (int row = 1; row <= n; row++) {

            // since the lower triangle for nepali flag is slight bigger than the upper triangle.
            for (int col = 1; col <= 2 * row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // stick of the flag
        for (int col = 1; col <= n / 2 + 1; col++) {
            System.out.println("*");
        }
    }
    
}