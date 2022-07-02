package Patterns.Iterations.Stars;

public class pattern3 {
    public static void main(String[] args) {
        draw(5);
    }
    /*
    *****
    ****
    ***
    **
    *
     */
    static void draw(int n) {
        // outer loop
        for (int row = 1; row <= n; row++) {
            // inner loop
            // n - row + 1 will give me the no of col in each row.
            // or simply take the loop from row to n.
            for (int col = row; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
