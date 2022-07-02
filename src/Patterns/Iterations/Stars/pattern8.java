package Patterns.Iterations.Stars;

public class pattern8 {
    public static void main(String[] args) {
        draw(10);
    }

    /*
        *
       ***
      *****
     *******
    *********
     */
    static void draw(int n) {
        int space =  n - 1;

        for (int row = 0; row < n; row++) {
            
            for (int sp = 1; sp <= space; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= 2 * row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
            space--;
        }
    }
}
