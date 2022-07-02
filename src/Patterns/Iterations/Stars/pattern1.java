package Patterns.Iterations.Stars;

public class pattern1 {
    public static void main(String[] args) {
        draw(5);
    }

    /*
    *****
    *****
    *****
    *****
    *****
     */
    static void draw(int n) {

        // outer loop -> row
        for (int row = 1; row <= n; row++) {
            // inner loop -> col
            // in every row there are n no of columns
            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
