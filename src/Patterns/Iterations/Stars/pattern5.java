package Patterns.Iterations.Stars;

public class pattern5 {
    public static void main(String[] args) {
        draw(10);
    }

    /*
    *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *
     */
    static void draw(int n) {
        // upper part
        // outer loop -> we are running n/2 row loop for upper portion 
        for (int row = 1; row <= n/2; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // lower portion
        // outer loop -> we are running n/2 row loop for lower portion
        for (int row = 1; row <= n/2; row++) {
            for (int col = 1; col <= (n/2-row+1-1); col++) { // -1 for removing the extra same size line.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
