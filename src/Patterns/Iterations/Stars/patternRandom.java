package Patterns.Iterations.Stars;

public class patternRandom {
    public static void main(String[] args) {
        draw(5);
    }

    /*
    *    *
    **   **
    ***  ***
    **** ****
    **********
    **** ****
    ***  ***
    **   **
    *    *
     */
    static void draw(int n) {

        for (int row = 1; row <= n; row++) {
            
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            
            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }
            
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = n - 1; row >= 1; row--) {
            
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            
            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }
            
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
