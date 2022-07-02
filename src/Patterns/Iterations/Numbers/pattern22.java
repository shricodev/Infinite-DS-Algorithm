package Patterns.Iterations.Numbers;

public class pattern22 {
    public static void main(String[] args) {
        draw(5);
    }

    /*
    1
    0 1
    1 0 1
    0 1 0 1
    1 0 1 0 1
     */
    static void draw(int n) {

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {

                // if the sum of row and col is even then the value to print is 1 else 0. 
                int toPrint = ((row + col) % 2 == 0) ? 1 : 0;
                System.out.print(toPrint + " ");
            }

            System.out.println();
        }
    }
}
