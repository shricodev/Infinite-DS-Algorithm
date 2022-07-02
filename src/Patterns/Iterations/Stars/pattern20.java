package Patterns.Iterations.Stars;

public class pattern20 {
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
            for (int col = 1; col <= n; col++) {
                if (row == 1 || col == 1 || col == n || row == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
