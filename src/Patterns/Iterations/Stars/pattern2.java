package Patterns.Iterations.Stars;

public class pattern2 {
    public static void main(String[] args) {
        draw(5);
    }

    /*
    *
    **
    ***
    ****
    *****
     */
    static void draw(int n) {

        // outer loop for row
        for (int row = 1; row <= n; row++) {
            // for column in the row
            for (int col = 1; col <= row; col++) {
                System.out.print("*");                
            }
            // for new line for every row.
            System.out.println();
        }
    }
}
