package Patterns.Iterations.Stars;

public class pattern9 {
    public static void main(String[] args) {
        draw(9);
    }

    /*
    *********
     *******
      *****
       ***
        *
     */
    static void draw(int n) {

        int space = 0;
        for (int row = 0; row < n - 3; row++) {

            for (int sp = 0; sp < space; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= n - (2 * row); col++) { 
                System.out.print("*");
            }

            System.out.println();
            space++;
        }
    }
}
